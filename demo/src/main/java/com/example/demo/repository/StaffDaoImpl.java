package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.example.demo.model.Staff;


@Service
public class StaffDaoImpl extends JdbcDaoSupport implements StaffDao{

	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@Override
	public List<Staff> getStaff(String store_no) {
		String sql = "select * from staff where store_no = ?";
		List<Staff> staff = (List<Staff>) getJdbcTemplate().query(sql,new Object[] {store_no},new StaffMapper());
		
		return staff;
	}

	public class StaffMapper implements RowMapper<Staff>{
		public Staff mapRow(ResultSet rs,int rowNum) throws SQLException{
			Staff staff = new Staff();
			
			staff.setResign_flag(rs.getString("resign_flag"));
			staff.setStaff_acntno(rs.getString("staff_acntno"));
			staff.setStaff_name(rs.getString("staff_name"));
			staff.setStaff_no(rs.getString("staff_no"));
			staff.setStaff_pnum(rs.getString("staff_pnum"));
			staff.setStaff_pos(rs.getString("staff_pos"));
			
			return staff;
		}
	}

}
