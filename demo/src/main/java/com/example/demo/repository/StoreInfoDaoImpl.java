package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StoreInfo;

@Repository
public class StoreInfoDaoImpl extends JdbcDaoSupport implements StoreInfoDao{

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public StoreInfo getStoreInfoById(String id) {
		String sql = "select store_no from acnt where acnt_id = ?";
		String store_no = null;
		try {
			store_no = (String)getJdbcTemplate().queryForObject(sql,new Object[] {id},String.class);
		}catch (EmptyResultDataAccessException e) {
			System.out.println("첫번째 쿼리 에러");
		}
		sql = "select * from tstore where store_no = ?";
		StoreInfo storeInfo = (StoreInfo)getJdbcTemplate().queryForObject(sql,new Object[] {store_no}, new StoreInfoMapper());
		
		sql = "select admin_name from admin where admin_no = ?";
		String admin_name = null;
		try {
			admin_name = (String)getJdbcTemplate().queryForObject(sql,new Object[] {storeInfo.getADMIN_NO()},String.class);
			storeInfo.setADMIN_NAME(admin_name);
		}catch (EmptyResultDataAccessException e) {
			System.out.println("세번째 쿼리 에러");
		}
		return storeInfo;
	}
	
	public class StoreInfoMapper implements RowMapper<StoreInfo> {
		
		public StoreInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			StoreInfo storeInfo = new StoreInfo();
			
			storeInfo.setADMIN_NO(rs.getString("admin_no"));
			storeInfo.setSTORE_CODE(rs.getString("store_code"));
			storeInfo.setSTORE_NAME(rs.getString("store_name"));
			storeInfo.setSTORE_NO(rs.getString("STORE_NO"));
			storeInfo.setSTORE_PNUM(rs.getString("STORE_PNUM"));
			storeInfo.setSTORE_POSTNO(rs.getString("STORE_POSTNO"));
			storeInfo.setSTORE_ADDR(rs.getString("STORE_ADDR"));
			
			return storeInfo;
		}
	}
}
