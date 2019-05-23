package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.demo.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Account;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class AccountMapper implements RowMapper<Account> {

		public Account mapRow(ResultSet rs, int rowNum) throws SQLException{
			Account account = new Account();

			account.setUsername(rs.getString("acnt_id"));
			account.setPassword(rs.getString("password"));
			account.setAcnt_store_no(rs.getString("store_no"));
			account.setAcnt_admin_no(rs.getString("admin_no"));

			return account;
		}
	}
	
	@Override
	public Account getAccountByUsername(String username) {
		String sql = "SELECT * FROM acnt WHERE acnt_id = ?";
		try {

		Account account = (Account)getJdbcTemplate().queryForObject(sql,new Object[] {username},new AccountMapper());
		return account;
		}catch (EmptyResultDataAccessException e) {
			System.out.println("authentication 쿼리 에러");
			return null;
		}
		//System.out.println(result);
	}


}
