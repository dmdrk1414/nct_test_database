package org.example.service;

import org.example.constant.MBTI;
import org.example.entity.Member;
import org.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }

    public String getEmail(Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getEmail();
    }
}
