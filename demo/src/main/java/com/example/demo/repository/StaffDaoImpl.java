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
			staff.setStore_no(rs.getString("store_no"));

			return staff;
		}
	}


	@Override
	public List<Staff> findByAcnt_store_no(String acnt_store_no) {
		String sql = "select * from staff where store_no = ?";
		List<Staff> staff = (List<Staff>) getJdbcTemplate().query(sql,new Object[] {acnt_store_no},new StaffMapper());
		return staff;
	}


	@Override
	public Staff getByStaff_no(String staff_no) {
		String sql = "select * from staff where staff_no = ?";
		Staff staff = (Staff)getJdbcTemplate().queryForObject(sql,new Object[] {staff_no}, new StaffMapper());
		
		return staff;
	}

	@Override
	public void updateStaff(Staff staff) {
		String sql = "update staff set staff_name=?,staff_pos=?,resign_flag=?,staff_acntno=?,staff_pnum=?,staff_acntbank=? where staff_no=?";
		getJdbcTemplate().update(sql, new Object[] {staff.getStaff_name(),staff.getStaff_pos(),staff.getResign_flag(),staff.getStaff_acntno(),
				staff.getStaff_pnum(),staff.getStaff_acntbank(),staff.getStaff_no()});
		
	}


	@Override
	public void insertStaff(Staff staff){
		String sql = "INSERT INTO STAFF (staff_name,staff_pos,store_no,resign_flag,staff_acntno,staff_pnum,staff_acntbank) values(?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {staff.getStaff_name(),staff.getStaff_pos(),staff.getStore_no(),
				staff.getResign_flag(),staff.getStaff_acntno(),staff.getStaff_pnum(),staff.getStaff_acntbank()});
		
	}
}
