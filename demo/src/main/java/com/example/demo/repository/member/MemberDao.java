package com.example.demo.repository.member;

import java.util.List;

import com.example.demo.dto.MemberMileage;
import com.example.demo.model.Member;

public interface MemberDao{
	List<Member> getMemberList();
	void insertMember(Member member);
	Member getByMemberNo(int member_no);
	void alterMemberInfo(Member member);
	MemberMileage getMileageInfo(int member_no);
	void alterMileageInfo(int member_no,int mileage);
}
