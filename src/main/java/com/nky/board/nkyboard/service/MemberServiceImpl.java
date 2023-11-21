package com.nky.board.nkyboard.service;

import com.nky.board.nkyboard.entity.Member;
import com.nky.board.nkyboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepo;
    @Override
    public Member read(String id){ return memberRepo.findById(id).orElse(null);}
    @Override
    public Member register(Member member){return memberRepo.save(member);}


}
