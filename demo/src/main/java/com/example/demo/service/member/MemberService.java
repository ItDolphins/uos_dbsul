package com.example.demo.service.member;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;

public interface MemberService {
	List<Member> getMemberList();
}
