package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.repository.StoreInfoDaoImpl.StoreInfoMapper;


@Repository
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
	public List<Staff> findbyAcnt_id(String id) {
		String sql = "select store_no from acnt where acnt_id = ?";
		String store_no = null;
			try {
				store_no = (String)getJdbcTemplate().queryForObject(sql,new Object[] {id},String.class);
			}catch (EmptyResultDataAccessException e) {
				System.out.println("첫번째 쿼리 에러");
		}

		sql = "select * from staff where store_no = ?";

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
			staff.setStaff_acntbank(rs.getString("staff_acntbank"));
			
			return staff;
		}
	}
	
	@Override
	public Staff findbyStaff_no(String staff_no) {
		String sql = "select * from staff where staff_no = ?";
		Staff staffInfo = (Staff)getJdbcTemplate().queryForObject(sql,new Object[] {staff_no}, new StaffInfoMapper());
		
		return staffInfo;
	}
	
	
	public class StaffInfoMapper implements RowMapper<Staff> {
		
		public Staff mapRow(ResultSet rs, int rowNum) throws SQLException{
			Staff staff = new Staff();
			staff.setResign_flag(rs.getString("resign_flag"));
			staff.setStaff_acntno(rs.getString("staff_acntno"));
			staff.setStaff_name(rs.getString("staff_name"));
			staff.setStaff_no(rs.getString("staff_no"));
			staff.setStaff_pnum(rs.getString("staff_pnum"));
			staff.setStaff_pos(rs.getString("staff_pos"));
			staff.setStaff_acntbank(rs.getString("staff_acntbank"));
			
			
			return staff;
		}
	}
	
	@Override
	public void updateStaffInfo(String staff_no,String staff_name,String staff_pos,String resign_flag,String staff_acntno,String staff_pnum,String staff_acntbank) {
		String sql = "update staff set staff_name=?,staff_pos=?,resign_flag=?,staff_acntno=?,staff_pnum=?,staff_acntbank=? where staff_no=?";
		getJdbcTemplate().update(sql, new Object[] {staff_name,staff_pos,resign_flag,staff_acntno,staff_pnum,staff_acntbank,staff_no});
		
	}
}
