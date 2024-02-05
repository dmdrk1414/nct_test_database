package org.example.repository;

import org.example.constant.MBTI;
import org.example.entity.Member;
import org.example.entity.MemberAdmin;
import org.example.entity.MemberInformation;
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
    private final MemberInformationRepository memberInformationRepository;
    private final MemberAdminRepository memberAdminRepository;


    @Autowired
    MemberRepositoryTest(MemberService memberService, MemberRepository memberRepository, MemberInformationRepository memberInformationRepository, MemberAdminRepository memberAdminRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
        this.memberInformationRepository = memberInformationRepository;
        this.memberAdminRepository = memberAdminRepository;
    }

    @BeforeEach
    void setUp() {
        memberRepository.deleteAll();
        memberInformationRepository.deleteAll();
        memberAdminRepository.deleteAll();
    }

    @Test
    void Member_저장_테스트() {
        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();

        // 원하는 형식의 문자열로 포맷팅하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = currentDate.format(formatter);

        // 1. 매핑 준비
        Member member = TestSetUp.getMember();
        MemberInformation memberInformation = TestSetUp.getMemberInformation();
        MemberAdmin memberAdmin = TestSetUp.getMemberAdmin();

        // 2. 매핑 member, memberInformation set
        member.setMemberInformation(memberInformation);
        member.setMemberAdmin(memberAdmin);

        // 등록
        Member member1 = memberRepository.save(member);

        Member target = memberRepository.findById(member1.getMemberId()).get();
        assertThat(target.getFirstName()).isEqualTo("박");
        assertThat(target.getLastName()).isEqualTo("승찬");
        assertThat(target.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(target.getRegistration()).isEqualTo(formattedDate);

        MBTI mbti = memberService.getMbti(target.getMemberId());
        System.out.println("mbti = " + mbti);

        String email = memberService.getEmail(target.getMemberId());
        System.out.println("email = " + email);
    }

    @Test
    void Member_update_테스트() {
        // 1. 매핑 준비
        Member member = TestSetUp.getMember();
        MemberInformation memberInformation = TestSetUp.getMemberInformation();
        MemberAdmin memberAdmin = TestSetUp.getMemberAdmin();

        // 2. 매핑 member, memberInformation set
        member.setMemberInformation(memberInformation);
        member.setMemberAdmin(memberAdmin);

        // 등록
        Member testMember = memberRepository.save(member);
//        memberInformationRepository.delete(testMember.getMemberInformation());
        memberRepository.delete(testMember);
//        memberAdminRepository.delete(testMember.getMemberAdmin());
    }
}