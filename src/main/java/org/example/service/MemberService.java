package org.example.service;

import org.example.constant.MBTI;
import org.example.entity.Member;
import org.example.entity.MemberAdmin;
import org.example.entity.MemberInformation;
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

    /**
     * 지연 로딩LAZY: 연관된 엔티티를 프정록시로 조회한다. 프록시를 실제 사용할 때 초기화하면서 데이터베이스를 조회한다.
     *
     * @param id
     * @return
     */
    public MBTI getMbti(Long id) {
        Member member = memberRepository.findById(id).get();
        MemberInformation memberInformation = member.getMemberInformation();
        return memberInformation.getMbti();
    }

    public String getEmail(Long id) {
        Member member = memberRepository.findById(id).get();
        MemberAdmin memberAdmin = member.getMemberAdmin();
        return memberAdmin.getEmail();
    }
}
