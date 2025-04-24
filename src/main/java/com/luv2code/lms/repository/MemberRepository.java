package com.luv2code.lms.repository;


import com.luv2code.lms.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

