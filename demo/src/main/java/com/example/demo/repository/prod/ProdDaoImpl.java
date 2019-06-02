package com.example.demo.repository.prod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Busi;
import com.example.demo.model.Prod;

@Transactional
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
			
			prod.setProd_no(rs.getInt("prod_no"));
			prod.setProd_price(rs.getInt("prod_price"));
			prod.setDmg_risk(rs.getString("dmg_risk"));
			prod.setProd_name(rs.getString("prod_name"));
			prod.setBusi_name(rs.getString("busi_name"));
			
			
			return prod;
		}
	}
	public class BusiMapper implements RowMapper<Busi>{

		@Override
		public Busi mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Busi busi=new Busi();
			
			busi.setBusi_no(rs.getInt("busi_no"));
			busi.setBusi_addr(rs.getString("busi_addr"));
			busi.setBusi_name(rs.getString("busi_name"));
			busi.setBusi_pNum(rs.getString("busi_pNum"));
			busi.setBusi_postNo(rs.getString("busi_postno"));
			return busi;
		}

	}

	@Override
	public void insertProdToDB(Prod prod) {
		// TODO Auto-generated method stub
		String sql = "insert into PROD (prod_name,prod_no,prod_price,dmg_risk,busi_no) values(?,SEQ_PROD.NEXTVAL,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {prod.getProd_name(),prod.getProd_price(),prod.getDmg_risk(),
			prod.getBusi_no()});
	}

	@Override
	public Busi matchBusiName(String busi_name) {
		// TODO Auto-generated method stub
		String sql ="Select * from BUSI where busi_name=?";
		Busi busi=(Busi)getJdbcTemplate().queryForObject(sql, new Object[] {busi_name}, new BusiMapper());
		return busi;
	}

	@Override
	public Prod findProdByNo(String prod_no) {
		// TODO Auto-generated method stub
		String sql="SELECT prod_no, prod_price, dmg_risk, prod_name, b.busi_name  FROM PROD  p, BUSI  b where p.busi_no=b.busi_no and p.prod_no=?";
		Prod prod = (Prod)getJdbcTemplate().queryForObject(sql,new Object[] {prod_no},new ProdMapper());
		
		return prod;
	}
	
	@Override
	public void alterProdToDB(Prod prod) {
		// TODO Auto-generated method stub
		String sql = "update prod set prod_name=?,prod_price=?,dmg_risk=?,busi_no=? where prod_no=?";
		getJdbcTemplate().update(sql,new Object[] {prod.getProd_name(),prod.getProd_price(),prod.getDmg_risk(),
			prod.getBusi_no(), prod.getProd_no()});
	}
	
	@Override
	public Optional<String> findByProdNo(int prod_no) {
		String sql = "select prod_no from prod where prod_no = ?";
		try {
			return Optional.of(getJdbcTemplate().queryForObject(sql, new Object[] {prod_no},String.class));
		} catch(EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public String getNameByProdNo(int prod_no) {
		String sql = "select prod_name from prod where prod_no = ?";
		String name = getJdbcTemplate().queryForObject(sql, new Object[] {prod_no},String.class);
		
		return name;
	}

	@Override
	public int getPriceByProdNo(int prod_no) {
		String sql = "select prod_price from prod where prod_no = ?";
		int price = getJdbcTemplate().queryForObject(sql,new Object[] {prod_no},int.class);
		
		return price;
	}
}