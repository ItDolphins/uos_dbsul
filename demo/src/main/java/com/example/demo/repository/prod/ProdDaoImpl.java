package com.example.demo.repository.prod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Prod;


@Repository
public class ProdDaoImpl extends JdbcDaoSupport implements ProdDao {

	@Autowired
	DataSource dataSource;
	

	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public ArrayList<Prod> findAllProd() {
		String sql = "SELECT prod_no, prod_price, dmg_risk, prod_name, b.busi_name  FROM PROD  p, BUSI  b where p.busi_no=b.busi_no";
		try {
			ArrayList<Prod> result = (ArrayList<Prod>)getJdbcTemplate().query(sql,new Object[] {},new ProdMapper());
		return result;
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public class ProdMapper implements RowMapper<Prod>{
		public Prod mapRow(ResultSet rs,int rowNum) throws SQLException{
			Prod prod=new Prod();
			
			prod.setProd_no(rs.getString("prod_no"));
			prod.setProd_price(rs.getInt("prod_price"));
			prod.setDmg_risk(rs.getString("dmg_risk"));
			prod.setProd_name(rs.getString("prod_name"));
			prod.setBusi_name(rs.getString("busi_name"));
			
			
			return prod;
		}
	}

	@Override
	public void insertProdToDB(Prod pord) {
		// TODO Auto-generated method stub
		String sql = "insert PROD (prod_name,prod_no,prod_price,dmg_risk,busi_no) values(?,?,?,?)";
		//getJdbcTemplate().update(sql,new Object[] {prod.getStaff_name(),staff.getStaff_pos(),staff.getStore_no(),
			//	staff.getResign_flag(),staff.getStaff_acntno(),staff.getStaff_pnum(),staff.getStaff_acntbank()});
	}

	@Override
	public Prod matchBusiName(String busi_no) {
		// TODO Auto-generated method stub
		String sql ="Select busi_name from BUSI where busi_no=?";
		Prod busi=(Prod)getJdbcTemplate().queryForObject(sql, new Object[] {busi_no}, new ProdMapper());
		return busi;
	}
}
