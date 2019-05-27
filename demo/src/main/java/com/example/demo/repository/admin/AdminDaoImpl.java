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
}
