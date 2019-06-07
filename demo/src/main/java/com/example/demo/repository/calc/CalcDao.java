package com.example.demo.repository.calc;

import com.example.demo.model.Calc;
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
public class CalcDao extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;


	@Autowired
	JdbcTemplate jdbcTemplateObject;


	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}


	public class CalcMapper implements RowMapper<Calc> {
		public Calc mapRow(ResultSet rs, int rowNum) throws SQLException {
			Calc calc = new Calc();
			calc.setStore_no(rs.getInt("store_no"));
			calc.setCalc_yrmn(rs.getDate("calc_yrmn"));
			calc.setMaint_amt(rs.getInt("maint_amt"));
			calc.setLabor_amt(rs.getInt("labor_amt"));
			calc.setMon_sales_amt(rs.getInt("mon_sales_amt"));
			calc.setHead_charge(rs.getInt("head_charge"));
			return calc;

		}
	}

	public List<Calc> findByStore_no(int store_no){
		String sql = "select * from calc where store_no = ?";
		List<Calc> calcList = (List<Calc>) getJdbcTemplate().query(sql, new Object[]{store_no}, new CalcMapper());
		return calcList;
	}


}
