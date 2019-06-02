package com.example.demo.repository.staff;


import com.example.demo.model.Work;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class WorkDaoImpl extends JdbcDaoSupport implements WorkDao {

	@Autowired
	DataSource dataSource;


	@Autowired
	JdbcTemplate jdbcTemplateObject;

	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}


	public class WorkMapper implements RowMapper<Work> {
		public Work mapRow(ResultSet rs, int rowNum) throws SQLException {
			Work work = new Work();
			work.setStaff_no(rs.getInt("staff_no"));
				work.setWork_start_time(rs.getTimestamp("work_start_time"));
				work.setWork_end_time(rs.getTimestamp("work_end_time"));
			return work;
		}
	}

	@Override
	public List<Work> findWorkByStaff_no(int staff_no){

		String sql = "select staff_no,  work_start_time," +
		" work_end_time from twork where staff_no = ? order by work_start_time desc";
		List<Work> workList = (List<Work>) getJdbcTemplate().query(sql,new Object[] {staff_no},new WorkMapper());
		return workList;

	}

	@Override
	public Work getWorkByStaff_noAndWork_start_time(int staff_no, Timestamp work_start_time){
		String sql = "select staff_no,work_start_time, " +
				" work_end_time  from twork where staff_no = ? and  work_start_time= ?";
		Work work =  (Work) getJdbcTemplate().queryForObject(sql, new Object[] {staff_no, work_start_time},new WorkMapper());
		return work;
	}

	@Override
	public void updateWork(Work work, Timestamp ex_work_start_time){
		String sql = "update twork set   work_start_time =? , work_end_time = ? " +
				" where staff_no = ? and work_start_time= ? ";
		getJdbcTemplate().update(sql,new Object[] {work.getWork_start_time(),
				work.getWork_end_time(),work.getStaff_no(), ex_work_start_time });
	}

	@Override
	public void insertWork(Work work){
		String sql = "insert into twork(staff_no ,work_start_time,work_end_time)" +
				" values(?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {work.getStaff_no(),
				work.getWork_start_time(),work.getWork_end_time()});
	}

}