package com.example.demo.repository.calc;

import com.example.demo.model.Calc;
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
		List<Calc> calcList = getJdbcTemplate().query(sql, new Object[]{store_no}, new CalcMapper());
		for (Calc calc : calcList){
			calc.setNet_profit(calc.getMon_sales_amt() -( calc.getHead_charge() + calc.getLabor_amt() + calc.getMaint_amt()  ));
		}
		return calcList;
	}

	public List<Calc> findByStore_noAndCalc_yrmn(int store_no, Date calc_yrmn){
		String sql = "select * from calc where store_no =? and calc_yrmn =?";
		List<Calc> calcList = getJdbcTemplate().query(sql, new Object[]{store_no, calc_yrmn}, new CalcMapper());
		return calcList;
	}

	public Calc getMon_sales_amtAndHead_charge(Calc calc){
		String sql = "select sum(sales_amt) sum_amt from sales s\n" +
				"                                        where s.store_no = ? and to_char(sales_date,'YYYYMM') " +
				"                                                   = to_char(?,'YYYYMM')\n" +
				"                                            group by to_char(sales_date,'YYYYMM')";
		int mon_sales_amt;
		try {
			mon_sales_amt = getJdbcTemplate().queryForObject(sql,new Object[]{calc.getStore_no(), calc.getCalc_yrmn()}, Integer.class);

		} catch (
				EmptyResultDataAccessException e) {
			mon_sales_amt = 0;
		}
		calc.setMon_sales_amt(mon_sales_amt);

		String sql2 = "select class_margin from tstore s, storeclassmargin m \n" +
				"    where s.store_class = m.store_class and store_no =?";

		int class_margin = getJdbcTemplate().queryForObject(sql2, new Object[]{calc.getStore_no()}, Integer.class);
		calc.setHead_charge( (class_margin*mon_sales_amt)/100);

		return  calc;
	}

	public void insertCalc(Calc calc){
		String sql = "insert into calc (store_no, calc_yrmn, maint_amt, labor_amt, mon_sales_amt, head_charge)" +
				" values(?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, calc.getStore_no(), calc.getCalc_yrmn(),calc.getMaint_amt(),
				calc.getLabor_amt(), calc.getMon_sales_amt(), calc.getHead_charge());
	}

	public void updateCalc(Calc calc){
		String sql = "update calc set maint_amt=?, labor_amt=?, mon_sales_amt=?, head_charge=?" +
				" where store_no= ? and calc_yrmn =?   ";
		getJdbcTemplate().update(sql,calc.getMaint_amt(),
				calc.getLabor_amt(), calc.getMon_sales_amt(), calc.getHead_charge(),
				calc.getStore_no(), calc.getCalc_yrmn());
	}


}
