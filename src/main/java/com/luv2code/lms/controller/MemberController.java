package com.luv2code.lms.controller;
import com.luv2code.lms.model.Member;
import com.luv2code.lms.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.addMember(member));
    }
}
