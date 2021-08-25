package com.member.management.service;

import com.member.management.domain.Member;
import com.member.management.execution.MemberNotFoundException;
import com.member.management.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MemberManagementService {
    @Autowired
    MemberRepository memberRepository;

    @Getter
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers(){
        this.members = memberRepository.findAllMember();
        return  members;
    }

    public List<Member> getMembersByName(String name){
        this.members = memberRepository.findMemberByName(name);
        return  members;
    }

    public List<Member> getMembersByPhoneNumber(String phoneNumber){
        this.members = memberRepository.findMemberByPhoneNumber(phoneNumber);
        return  members;
    }

    public List<Member> getMemberByAll(String name,String email,String phoneNum, String nickName){
        this.members = memberRepository.findMemberByAll(name,email,phoneNum,nickName);
        return members;
    }

    public void insertMember(Member newMember){
        this.members = memberRepository.findAllMember();

        members.add(newMember);
        memberRepository.insertMember(newMember);
    }
    
}
