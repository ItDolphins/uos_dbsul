package com.example.demo.repository.calc;

import com.example.demo.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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

	public List<Sales> findByStore_no(int store_no) {
		String sql = "select * from sales where store_no = ?";
		List<Sales> salesList = getJdbcTemplate().query(sql, new Object[]{store_no}, new SalesMapper());
		return salesList;
	}

	public List<Sales> findByStore_noAndSales_date(int store_no, Date sales_date) {
		String sql = "select * from sales where store_no = ? and sales_date = ?";
		List<Sales> salesList = getJdbcTemplate().query(sql, new Object[]{store_no, sales_date}, new SalesMapper());
		return salesList;
	}


	public int getSales_amt(int store_no, Date sales_date) {

		String sql = "select sum(sell_price) sum_amt from sell s ,rls r " +
				"where r.store_no = ? and to_char(rls_date,'YYYYMMDD') = to_char(?,'YYYYMMDD') and  s.rls_no = r.rls_no " +
				"group by to_char(rls_date,'YYYYMMDD')";
		int sales_amt ;
		try {
			sales_amt = getJdbcTemplate().queryForObject(sql, new Object[]{store_no, sales_date}, Integer.class);
		} catch (
				EmptyResultDataAccessException e) {
			sales_amt = 0;
		}
		return sales_amt;
	}

	public void insertSales(Sales sales) {
		String sql = "insert into sales (store_no, sales_date, sales_amt) values(?,?,?)";
		getJdbcTemplate().update(sql, sales.getStore_no(), sales.getSales_date(), sales.getSales_amt());

	}

	public void updateSales(Sales sales) {
		String sql = "update sales set  sales_amt= ?   where store_no = ? and sales_date = ? ";
		getJdbcTemplate().update(sql, sales.getSales_amt(), sales.getStore_no(), sales.getSales_date());

	}


}
