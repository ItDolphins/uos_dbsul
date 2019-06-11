package com.example.demo.service.member;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MemberMileage;
import com.example.demo.model.Member;

public interface MemberService {
	List<Member> getMemberList();
	void insertMember(Member member);
	Member getByMemberNo(int member_no);
	void alterMemberInfo(Member member);
	MemberMileage getMileageInfo(int member_no);
	void alterMileageInfo(int member_no,int mileage);
}
