package com.member.management.controller;

import com.member.management.domain.Member;
import com.member.management.service.MemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberManagementService memberManagementService;

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMembers(@RequestBody Member member){
        memberManagementService.insertMember(member);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberManagementService.getMembers();
    }

}
