package com.example.demo.repository.calc;

import com.example.demo.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class SalesDao extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;


	@Autowired
	JdbcTemplate jdbcTemplateObject;


	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}


	public class SalesMapper implements RowMapper<Sales> {
		public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sales sales = new Sales();
			sales.setStore_no(rs.getInt("store_no"));
			sales.setSales_date(rs.getDate("sales_date"));
			sales.setSales_amt(rs.getInt("sales_amt"));
			return sales;
		}
	}

	public List<Sales> findByStore_no(int store_no){
		String sql = "select * from sales where store_no = ?";
		List<Sales> salesList = (List<Sales>) getJdbcTemplate().query(sql, new Object[]{store_no}, new SalesMapper());
		return salesList;
	}


}
