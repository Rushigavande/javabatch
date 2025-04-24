package com.luv2code.lms.service;

import com.luv2code.lms.model.Member;
import com.luv2code.lms.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
}
