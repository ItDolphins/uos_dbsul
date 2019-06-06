package com.example.demo.repository.member;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;

@Transactional
@Repository
public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public class MemberListMapper implements RowMapper<Member>{
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
			Member member = new Member();
			
			member.setMember_birth(rs.getDate("member_birth"));
			member.setMember_class(rs.getString("member_class"));
			member.setMember_gend(rs.getString("member_gend"));
			member.setMember_mileage(rs.getInt("member_mileage"));
			member.setMember_name(rs.getString("member_name"));
			member.setMember_no(rs.getInt("member_no"));
			member.setMember_reg_day(rs.getDate("member_reg_day"));
			
			return member;
		}
	}
	
	@Override
	public List<Member> getMemberList() {
		String sql = "select * from tmember";
		List<Member> memberList = (List<Member>)getJdbcTemplate().query(sql, new Object[] {},new MemberListMapper());
		
		return memberList;
	}

	@Override
	public void insertMember(Member member) {
		Date sqlDate = new Date(new java.util.Date().getTime());
		String sql = "INSERT INTO tmember (member_gend,member_birth,member_name,member_reg_day,member_mileage,member_class)"
				+ " values(?,?,?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {member.getMember_gend(),member.getMember_birth(),member.getMember_name(),sqlDate,0,"브론즈"});
		
	}

	@Override
	public Member getByMemberNo(int member_no) {
		String sql = "select * from tmember where member_no = ?";
		Member member = getJdbcTemplate().queryForObject(sql, new Object[] {member_no}, new MemberListMapper());
		
		return member;
	}

	@Override
	public void alterMemberInfo(Member member) {
		String sql = "update tmember set member_gend=?,member_birth=?,member_name=?,member_mileage=?,member_class=? where member_no = ?";
		getJdbcTemplate().update(sql,new Object[] {member.getMember_gend(),member.getMember_birth(),member.getMember_name(),
				member.getMember_mileage(),member.getMember_class(),member.getMember_no()});
		
	}

}
