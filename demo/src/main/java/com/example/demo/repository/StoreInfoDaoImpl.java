package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StoreInfo;

@Repository
public class StoreInfoDaoImpl extends JdbcDaoSupport implements StoreInfoDao {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class StoreInfoMapper implements RowMapper<StoreInfo> {

		public StoreInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			StoreInfo storeInfo = new StoreInfo();

			storeInfo.setAdmin_no(rs.getString("admin_no"));
			storeInfo.setAdmin_name(rs.getString("admin_name"));
			storeInfo.setStore_code(rs.getString("store_code"));
			storeInfo.setStore_name(rs.getString("store_name"));
			storeInfo.setStore_no(rs.getString("store_no"));
			storeInfo.setStore_pnum(rs.getString("store_pnum"));
			storeInfo.setStore_postno(rs.getString("store_postno"));
			storeInfo.setStore_addr(rs.getString("store_addr"));

			return storeInfo;
		}
	}

	@Override
	public StoreInfo getByStore_no(String acnt_store_no) {
		String sql = "select t.store_code, t.store_name, t.store_no, t.store_pnum,t.store_addr, t.store_postno,a.admin_no, a.admin_name " +
				"from tstore  t, tadmin  a where t.store_no = ? and t.admin_no = a.admin_no";
		StoreInfo storeInfo = (StoreInfo)getJdbcTemplate().queryForObject(sql,new Object[] {acnt_store_no}, new StoreInfoMapper());

		return storeInfo;
	}
}
