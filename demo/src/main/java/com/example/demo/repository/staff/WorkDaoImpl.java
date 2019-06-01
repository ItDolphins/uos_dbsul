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
import java.util.List;

@Transactional
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
			work.setStaff_no(rs.getInt("staff_no"));
			work.setWork_no(rs.getInt("work_no"));
			work.setWork_start_time(rs.getDate("work_start_time"));
			work.setWork_end_time(rs.getDate("work_end_time"));

			return work;
		}
	}

	@Override
	public List<Work> findWorkByStaff_no(int staff_no){

		String sql = "select * from twork where staff_no = ? order by work_start_time desc";
		List<Work> workList = (List<Work>) getJdbcTemplate().query(sql,new Object[] {staff_no},new WorkMapper());
		return workList;

	}

	@Override
	public Work getWorkByWork_no(int work_no){
		String sql = "select * from twork where work_no = ?";
		Work work =  (Work) getJdbcTemplate().queryForObject(sql, new Object[] {work_no},new WorkMapper());
		return work;
	}

	@Override
	public void updateWork(Work work){
		String sql = "update twork set  staff_no = ? , work_start_time =? , work_end_time = ? " +
				"where work_no = ? ";
		getJdbcTemplate().update(sql,new Object[] {work.getStaff_no(), work.getWork_start_time(),
				work.getWork_end_time(),work.getWork_no()});
	}

	@Override
	public void insertWork(Work work){
		String sql = "insert into twork(staff_no ,work_start_time,work_end_time)" +
				" values(?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {work.getStaff_no(),
				work.getWork_start_time(),work.getWork_end_time()});
	}

}
