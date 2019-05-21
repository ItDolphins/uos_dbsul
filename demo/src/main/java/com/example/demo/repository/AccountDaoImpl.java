package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public String getPw(String id) {
		String sql = "SELECT password FROM acnt WHERE acnt_id = ?";
		try {
		String result = (String)getJdbcTemplate().queryForObject(sql,new Object[] {id},String.class);
		return result;
		}catch (EmptyResultDataAccessException e) {
			return "oh no";
		}
		//System.out.println(result);
	}
}
