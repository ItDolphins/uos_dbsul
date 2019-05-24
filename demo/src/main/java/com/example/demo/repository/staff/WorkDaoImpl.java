package com.example.demo.repository.staff;

import com.example.demo.model.Staff;
import com.example.demo.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class WorkDaoImpl extends JdbcDaoSupport implements WorkDao {

	@Autowired
	DataSource dataSource;


	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}


	public class WorkMapper implements RowMapper<Work> {
		public Work mapRow(ResultSet rs, int rowNum) throws SQLException {
			Work work = new Work();

			work.setWork_no(rs.getString("work_no"));
			work.setWork_start_time(rs.getDate("work_start_time"));
			work.setWork_end_time(rs.getDate("work_end_time"));

			return work;
		}
	}

	@Override
	public List<Work> findWorkByStaff_no(String staff_no){

		String sql = "select * from twork where staff_no = ?";
		List<Work> workList = (List<Work>) getJdbcTemplate().query(sql,new Object[] {staff_no},new WorkMapper());
		return workList;

	}


}
