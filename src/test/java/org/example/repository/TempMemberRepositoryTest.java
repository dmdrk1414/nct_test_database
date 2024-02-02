package org.example.repository;

import org.example.entity.Member;
import org.example.entity.TempMember;
import org.example.myutill.CustomLocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class TempMemberRepositoryTest {
    private final TempMemberRepository tempMemberRepository;

    @Autowired
    TempMemberRepositoryTest(TempMemberRepository tempMemberRepository) {
        this.tempMemberRepository = tempMemberRepository;
    }

    @BeforeEach
    void setUp() {
        this.tempMemberRepository.deleteAll();
    }

    @Test
    void TempMember_저장_테스트() {
        for (int i = 0; i < 10; i++) {
            tempMemberRepository.save(
                    TempMember.builder()
                            .firstName("박")
                            .lastName("승찬")
                            .phoneNumber("010-0000-0000")
                            .major("컴퓨터공학과")
                            .gpa("4.5")
                            .specialtySkill("100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ")
                            .hobby("달리기")
                            .mbti("MBTI")
                            .studentId("20249999")
                            .birthDate(CustomLocalDate.parse2BirthDateFromString("1996-04-15"))
                            .advantage("100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ")
                            .disadvantage("100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ")
                            .introduction("200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 ")
                            .photo("사진")
                            .email("email" + i + "@test.com")
                            .password("1234")
                            .build()
            );
        }

        assertThat(tempMemberRepository.count()).isEqualTo(10);

        List<TempMember> tempMembers = tempMemberRepository.findAll();
        for (int i = 0; i < 10; i++) {
            assertThat(tempMembers.get(i).getFirstName()).isEqualTo("박");
            assertThat(tempMembers.get(i).getLastName()).isEqualTo("승찬");
            assertThat(tempMembers.get(i).getPhoneNumber()).isEqualTo("010-0000-0000");
            assertThat(tempMembers.get(i).getBirthDate()).contains("1996-04-15");
        }
    }
}