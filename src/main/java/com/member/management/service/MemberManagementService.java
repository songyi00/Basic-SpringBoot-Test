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
        members = memberRepository.findAllMember();
        return  members;
    }

    public List<Member> getMembersByName(String name){
        members = memberRepository.findMemberByName(name);
        return  members;
    }

    public List<Member> getMembersByPhoneNumber(String phoneNumber){
        members = memberRepository.findMemberByPhoneNumber(phoneNumber);
        return  members;
    }

    public List<Member> getMemberByAll(String name,String email,String phoneNum, String nickName){
        members = memberRepository.findMemberByAll(name,email,phoneNum,nickName);
        return members;
    }

    public void insertMember(Member newMember){
        members = memberRepository.findAllMember();

        for (Member member : members){
            if (member.getPhoneNumber().equals(newMember.getPhoneNumber())){
                throw new MemberNotFoundException();
            }
        }
        members.add(newMember);
        memberRepository.insertMember(newMember);
    }

}
