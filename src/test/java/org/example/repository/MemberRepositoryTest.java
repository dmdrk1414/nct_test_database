package org.example.repository;

import org.example.entity.Member;
import org.example.myutill.CustomLocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class MemberRepositoryTest {
    private final MemberRepository memberRepository;


    @Autowired
    MemberRepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @BeforeEach
    void setUp() {
        memberRepository.deleteAll();
    }

    @Test
    void Member_저장_테스트() {
        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();

        // 원하는 형식의 문자열로 포맷팅하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedDate = currentDate.format(formatter);

        for (int i = 0; i < 10; i++) {
            memberRepository.save(
                    Member.builder()
                            .firstName("박")
                            .lastName("승찬")
                            .phoneNumber("010-0000-0000")
                            .major("컴퓨터공학과")
                            .birthDate(CustomLocalDate.parse2BirthDateFromString("1996-04-15"))
                            .studentId("20249999")
                            .build()
            );
        }
        System.out.println("formattedDate = " + formattedDate);

        List<Member> members = memberRepository.findAll();
        for (int i = 0; i < 10; i++) {
            assertThat(members.get(i).getFirstName()).isEqualTo("박");
            assertThat(members.get(i).getLastName()).isEqualTo("승찬");
            assertThat(members.get(i).getPhoneNumber()).isEqualTo("010-0000-0000");
            assertThat(members.get(i).getRegistration()).isEqualTo(formattedDate);
        }
    }
}