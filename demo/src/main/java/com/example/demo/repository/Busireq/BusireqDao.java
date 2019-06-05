package com.example.demo.repository.Busireq;


import com.example.demo.model.Busireq;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BusireqDao extends JdbcDaoSupport  {


	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class BusireqMapper implements RowMapper<Busireq> {

		public Busireq mapRow(ResultSet rs, int rowNum) throws SQLException {
			Busireq busireq = new Busireq();

			busireq.setReq_no(rs.getInt("req_no"));
			busireq.setOrder_no(rs.getInt("order_no"));
			busireq.setBusi_conf_flag(rs.getString("busi_conf_flag"));
			busireq.setOrder_date(rs.getDate("order_date"));
			busireq.setDeliv_date(rs.getDate("deliv_date"));
			busireq.setDeliv_state(rs.getString("deliv_state"));
			busireq.setProd_no(rs.getInt("prod_no"));
			busireq.setReq_qnt(rs.getInt("req_qnt"));

			return busireq;
		}
	}

	public Busireq findByReq_no(int req_no){
		String sql = "select * from busireq where req_no = ?";
		Busireq busireq = getJdbcTemplate().queryForObject(sql, new Object[] {req_no}, new BusireqMapper());
		return busireq;
	}

	public List<Busireq> findByOrder_no(int order_no){
		String sql  = "select * from busireq where order_no = ? ";
		List<Busireq> busireqList = getJdbcTemplate().query(sql, new Object[]{order_no} , new BusireqMapper());

		return busireqList;
	}

	public List<Busireq> findByOrder_noAndNotDeliv_state(int order_no ,String deliv_state){
		String sql = "select * from busireq where order_no = ? and deliv_state <> ?";
		List<Busireq> busireqList;
		try {
			busireqList = (List<Busireq>) getJdbcTemplate().query(sql, new Object[]{order_no, deliv_state}, new BusireqMapper());
		}
		catch (NullPointerException e){
			return null;
		}
		return busireqList;
	}

	public void insertBusireq(Busireq busireq){
		String sql = "insert into busireq (order_no, busi_conf_flag, order_date, deliv_date," +
				"deliv_state, prod_no, req_qnt) values(?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[]{
				busireq.getOrder_no(), busireq.getBusi_conf_flag(),busireq.getOrder_date(),
				busireq.getDeliv_date(), busireq.getDeliv_state(), busireq.getProd_no(),
				busireq.getReq_qnt()
		});
	}

	public void updateBusireq(Busireq busireq){
		String sql = "update busireq set busi_conf_flag=?, order_date=?, deliv_date=? , deliv_state=? " +
				"where req_no = ?";
		getJdbcTemplate().update(sql, new Object[] {busireq.getBusi_conf_flag(), busireq.getOrder_date()
		, busireq.getDeliv_date(), busireq.getDeliv_state(), busireq.getReq_no()});
	}

}
