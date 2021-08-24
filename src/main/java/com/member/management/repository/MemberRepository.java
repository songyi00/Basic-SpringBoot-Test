package com.member.management.repository;

import com.member.management.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    // 전체 조회
    public List<Member> findAllMember(){
        List<Member> list = mongoTemplate.findAll(Member.class);
        return list;
    }
    // 전체 정보로 조회
    public  List<Member> findMemberByAll(String name,String email,String phoneNum, String nickName){
        Query query = new Query(new Criteria("name").is(name).and("email").is(email).and("phoneNumber").is(phoneNum).and("nickName").is(nickName));
        List<Member> list = mongoTemplate.find(query, Member.class);
        return list;
    }
    // name 으로 조회
    public  List<Member> findMemberByName(String name){
        Query query = new Query(new Criteria("name").is(name));
        List<Member> list = mongoTemplate.find(query, Member.class);
        return list;
    }
    // phoneNumber 로 조회
    public List<Member> findMemberByPhoneNumber(String phoneNum){
        Query query = new Query(new Criteria("phoneNumber").is(phoneNum));
        List<Member> list = mongoTemplate.find(query, Member.class);
        return list;
    }

    public void insertMember(Member member){
        mongoTemplate.insert(member,"member");
    }
}
