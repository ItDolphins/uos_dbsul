package com.example.demo.repository.Busireq;


import com.example.demo.model.Wrhs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional
@Repository
public class WrhsDao extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class WrhsMapper implements RowMapper<Wrhs> {

		public Wrhs mapRow(ResultSet rs, int rowNum) throws SQLException {
			Wrhs wrhs = new Wrhs();

			wrhs.setWrhs_no(rs.getInt("wrhs_no"));
			wrhs.setReq_no(rs.getInt("req_no"));
			wrhs.setWrhs_date(rs.getDate("wrhs_date"));
			wrhs.setExpdate(rs.getDate("expdate"));

			return wrhs;
		}
	}


	public void insertWrhs(Wrhs wrhs){
		String sql = "insert into wrhs (req_no, wrhs_date, expdate)" +
				" values(?,trunc(?),trunc(?))";
		getJdbcTemplate().update(sql, wrhs.getReq_no(), wrhs.getWrhs_date(), wrhs.getExpdate());
	}
}
