package com.example.demo.repository.release;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Release;
import com.example.demo.model.Stock;

@Transactional
@Repository
public class ReleaseDaoImpl extends JdbcDaoSupport implements ReleaseDao{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public class ReleaseListMapper implements RowMapper<Release>{
		
		public Release mapRow(ResultSet rs, int rowNum) throws SQLException{
			Release rls = new Release();
					
			rls.setRls_no(rs.getInt("rls_no"));
			rls.setStore_no(rs.getInt("store_no"));
			rls.setRls_code(rs.getString("rls_code"));
			rls.setRls_date(rs.getTimestamp("rls_date"));
			rls.setExpdate(rs.getDate("expdate"));
			rls.setProd_no(rs.getInt("rls_no"));
			rls.setRls_qnt(rs.getInt("rls_qnt"));
			
			return rls;
		}
	}
	@Override
	public List<Release> getReleaseList() {
		String sql = "select * from rls";
		List<Release> releaseList = (List<Release>)getJdbcTemplate().query(sql, new Object[] {},new ReleaseListMapper());
		
		return releaseList;
	}

	@Override
	public void insertRelease(Stock stock, String rls_code, Timestamp rls_date,int rls_qnt) {
		String sql = "INSERT INTO rls (store_no,rls_code,rls_date,prod_no,expdate,rls_qnt)"
				+ " values(?,?,?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {stock.getStore_no(),rls_code,rls_date,stock.getProd_no(),stock.getExpdate(),rls_qnt});
		
		
	}

	@Override
	public int getMaxRlsno() {
		String sql = "SELECT MAX(rls_no) FROM rls";
		int result = getJdbcTemplate().queryForObject(sql, new Object[] {},int.class);
		return result;
	}

}
