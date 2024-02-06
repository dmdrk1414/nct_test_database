package org.example.repository;

import org.example.constant.MEMBER_GRADE;
import org.example.entity.MemberAdmin;
import org.example.entity.MemberInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class MemberAdminRepositoryTest {
    private final MemberAdminRepository memberAdminRepository;

    @Autowired
    MemberAdminRepositoryTest(MemberAdminRepository memberAdminRepository) {
        this.memberAdminRepository = memberAdminRepository;
    }

    @BeforeEach
    void setUp() {
        this.memberAdminRepository.deleteAll();
    }

    @Test
    @Disabled
    void Member_Admin_저장_테스트() {
        String email = "test@test.com";
        String password = "1234";
        MEMBER_GRADE memberGrade = MEMBER_GRADE.MEMBER;

        for (int i = 0; i < 10; i++) {
            memberAdminRepository.save(
                    MemberAdmin.builder()
                            .email(i + email)
                            .password(password)
                            .grade(memberGrade)
                            .build()
            );
        }

        List<MemberAdmin> memberAdmins = memberAdminRepository.findAll();
        for (int i = 0; i < 10; i++) {
            assertThat(memberAdmins.get(i).getEmail()).isEqualTo(i + email);
            assertThat(memberAdmins.get(i).getPassword()).isEqualTo(password);
            assertThat(memberAdmins.get(i).getGrade()).isEqualTo(memberGrade);
        }
    }
}