package com.example.demo.repository.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.StoreInfo;
import com.example.demo.service.admin.AdminService;

@Transactional
@Repository
public class StoreInfoDaoImpl extends JdbcDaoSupport implements StoreInfoDao {

	@Autowired 
	DataSource dataSource;
	
	@Autowired
	AdminService adminService;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class StoreInfoMapper implements RowMapper<StoreInfo> {

		public StoreInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			StoreInfo storeInfo = new StoreInfo();

			storeInfo.setAdmin_no(rs.getInt("admin_no"));
			storeInfo.setAdmin_name(rs.getString("admin_name"));
			storeInfo.setStore_class(rs.getString("store_class"));
			storeInfo.setStore_name(rs.getString("store_name"));
			storeInfo.setStore_no(rs.getInt("store_no"));
			storeInfo.setStore_pnum(rs.getString("store_pnum"));
			storeInfo.setStore_postno(rs.getString("store_postno"));
			storeInfo.setStore_addr(rs.getString("store_addr"));

			return storeInfo;
		}
	}

	@Override
	public StoreInfo getByStore_no(int acnt_store_no) {
		String sql = "select t.store_class, t.store_name, t.store_no, t.store_pnum,t.store_addr, t.store_postno,a.admin_no, a.admin_name " +
				"from tstore  t, tadmin  a where t.store_no = ? and t.admin_no = a.admin_no";
		StoreInfo storeInfo = (StoreInfo)getJdbcTemplate().queryForObject(sql,new Object[] {acnt_store_no}, new StoreInfoMapper());

		return storeInfo;
	}


	@Override
	public List<StoreInfo> StoreList() {
		String sql = "select t.store_class, t.store_name, t.store_no, t.store_pnum,t.store_addr, t.store_postno,a.admin_no, a.admin_name " +
				"from tstore  t, tadmin  a where t.admin_no = a.admin_no";
		List<StoreInfo> store = (List<StoreInfo>)getJdbcTemplate().query(sql, new Object[] {},new StoreInfoMapper());
		return store;
	}


	@Override
	public void insertStoreInfo(StoreInfo store) {
		String sql = "INSERT INTO tstore(store_name,store_addr,store_pnum,admin_no,store_postno) values(?,?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {store.getStore_name(),store.getStore_addr(),store.getStore_pnum(),store.getAdmin_no(),store.getStore_postno()});
		
		
	}


	@Override
	public void updateStoreInfo(StoreInfo store) {
		String sql = "UPDATE tstore set store_name=?,store_addr=?,store_pnum=?,store_postno=?,admin_no=? where store_no=?";
		getJdbcTemplate().update(sql,new Object[] {store.getStore_name(),store.getStore_addr(),store.getStore_pnum(),store.getStore_postno(),store.getAdmin_no(),store.getStore_no()});
	
		
		
	}

	public class store_noMapper implements RowMapper<Integer> {
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			return rs.getInt("store_no");
		}
	}

	public List<Integer> findStore_noByAdmin_no(int admin_no){
		String sql = "select store_no " +
				"from tstore  where  admin_no = ?";
		List<Integer> store_noList = (List<Integer>) getJdbcTemplate().query(sql, new Object[] { admin_no}, new store_noMapper() );
		return store_noList;
	}
}