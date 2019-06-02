package com.example.demo.repository.member;

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

}
