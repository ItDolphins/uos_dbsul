package com.example.demo.repository.sell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Sell;

@Transactional
@Repository
public class SellDaoImpl extends JdbcDaoSupport implements SellDao{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public class SellMapper implements RowMapper<Sell>{
		public Sell mapRow(ResultSet rs,int rowNum) throws SQLException{
			Sell sell = new Sell();
			
			sell.setMember_no(rs.getInt("member_no"));
			sell.setRls_no(rs.getInt("rls_no"));
			sell.setSell_no(rs.getInt("sell_no"));
			sell.setSell_price(rs.getInt("sell_price"));
			
			return sell;
		}
	}
	@Override
	public void insertSell(Sell sell) {
		String sql = "INSERT INTO sell (rls_no,member_no,sell_price) values(?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {sell.getRls_no(),sell.getMember_no(),sell.getSell_price()});
	}

	@Override
	public List<Sell> getSellList() {
		String sql = "SELECT * FROM sell";
		List<Sell> sellList = getJdbcTemplate().query(sql,new Object[] {},new SellMapper());
		
		return sellList;
	}

}
