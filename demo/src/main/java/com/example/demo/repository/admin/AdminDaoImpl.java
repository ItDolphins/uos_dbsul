package com.example.demo.repository.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Admin;

@Transactional
@Repository
public class AdminDaoImpl extends JdbcDaoSupport implements AdminDao{

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public class NameMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs,int rowNum) throws SQLException {
			String adminName;
			
			adminName = rs.getString("admin_name");
			
			return adminName;
		}
	}
	
	public class AdminMapper implements RowMapper<Admin>{
		public Admin mapRow(ResultSet rs,int rowNum) throws SQLException{
			Admin admin = new Admin();
			
			admin.setAdmin_name(rs.getString("admin_name"));
			admin.setAdmin_no(rs.getString("admin_no"));
			admin.setAdmin_pnum(rs.getString("admin_pnum"));
			admin.setAdmin_pos(rs.getString("admin_pos"));
			
			return admin;
		}
	}
	
	@Override
	public List<String> adminNameList() {
		String sql = "select distinct admin_name from tadmin";
		List<String> adminNameList = (List<String>)getJdbcTemplate().query(sql, new Object[] {},new NameMapper());
		return adminNameList;
	}

	@Override
	public Optional<String> findByAdminNo(String admin_no) {
		String sql = "select admin_no from tadmin where admin_no = ?";
		try {
			return Optional.of(getJdbcTemplate().queryForObject(sql, new Object[] {admin_no},String.class));
		} catch(EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public String getByAdminNo(String adminNo) {
		return findByAdminNo(adminNo).orElseThrow(() -> new IllegalArgumentException("Cannot find Admin by No : " + adminNo));
	}

	@Override
	public List<Admin> getAdminList() {
		String sql = "select * from tadmin";
		List<Admin> admin = (List<Admin>)getJdbcTemplate().query(sql,new Object[] {},new AdminMapper());
		
		return admin;
	}

	@Override
	public void insertAdminInfo(Admin admin) {
		String sql = "INSERT INTO tadmin (admin_name,admin_pos,admin_pnum) values(?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {admin.getAdmin_name(),admin.getAdmin_pos(),admin.getAdmin_pnum()});
		
	}

	@Override
	public Admin getInfoByAdminNo(String adminNo) {
		String sql = "SELECT * from tadmin where admin_no = ?";
		Admin admin = getJdbcTemplate().queryForObject(sql, new Object[] {adminNo},new AdminMapper());
		
		return admin;
	}

	@Override
	public void alterAdminInfo(Admin admin) {
		String sql = "update tadmin set admin_name=?,admin_pos=?,admin_pnum=? where admin_no=?";
		getJdbcTemplate().update(sql,new Object[] {admin.getAdmin_name(),admin.getAdmin_pos(),admin.getAdmin_pnum(),admin.getAdmin_no()});
		
	}
}
