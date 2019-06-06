package com.example.demo.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;
import com.example.demo.repository.member.MemberDao;

@Transactional
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = memberDao.getMemberList();
		return memberList;
	}

	@Override
	public void insertMember(Member member) {
		memberDao.insertMember(member);
		
	}

	@Override
	public Member getByMemberNo(int member_no) {
		Member member = memberDao.getByMemberNo(member_no);
		return member;
	}

	@Override
	public void alterMemberInfo(Member member) {
		memberDao.alterMemberInfo(member);
		
	}

}
