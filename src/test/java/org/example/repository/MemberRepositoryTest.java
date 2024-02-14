package org.example.repository;

import org.example.constant.MBTI;
import org.example.entity.Member;
import org.example.service.MemberService;
import org.example.testutill.TestSetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class MemberRepositoryTest {
    private final MemberService memberService;
    private final MemberRepository memberRepository;


    @Autowired
    MemberRepositoryTest(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @BeforeEach
    void setUp() {
        memberRepository.deleteAll();
    }

    @Test
    void Member_저장_테스트() {
        final Member representativMember = TestSetUp.getRepresentativMember();

        memberRepository.save(representativMember);

        Member targetMember = memberRepository.findById(representativMember.getMemberId()).get();

        assertThat(targetMember.getFirstName()).isEqualTo(targetMember.getFirstName());
        assertThat(targetMember.getEmail()).isEqualTo(targetMember.getEmail());
        assertThat(targetMember.getStudentId()).isEqualTo(targetMember.getStudentId());
    }

    @Test
    void Member_update_테스트() {
        // 1. 매핑 준비

    }
}