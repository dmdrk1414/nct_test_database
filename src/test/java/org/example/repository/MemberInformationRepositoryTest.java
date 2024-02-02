package org.example.repository;

import org.example.constant.MBTI;
import org.example.entity.MemberInformation;
import org.example.entity.TempMember;
import org.example.myutill.CustomLocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@SpringBootTest()
@AutoConfigureMockMvc
class MemberInformationRepositoryTest {
    private final MemberInformationRepository memberInformationRepository;

    @Autowired
    MemberInformationRepositoryTest(MemberInformationRepository memberInformationRepository) {
        this.memberInformationRepository = memberInformationRepository;
    }

    @BeforeEach
    void setUp() {
        this.memberInformationRepository.deleteAll();
    }

    @Test
    void Member_Information_저장_테스트() {
        String gpa = "4.5";
        String hobby = "달리기";
        String photo = "사진";
        String specialtySkill = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String advantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String disadvantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String introduction = "200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 ";
        MBTI mbti = MBTI.ENTP;
        for (int i = 0; i < 10; i++) {
            memberInformationRepository.save(
                    MemberInformation.builder()
                            .gpa(gpa)
                            .specialtySkill(specialtySkill)
                            .hobby(hobby)
                            .mbti(mbti)
                            .advantage(advantage)
                            .disadvantage(disadvantage)
                            .introduction(introduction)
                            .photo(photo)
                            .build()
            );
        }

        assertThat(memberInformationRepository.count()).isEqualTo(10);

        List<MemberInformation> memberInformations = memberInformationRepository.findAll();
        for (int i = 0; i < 10; i++) {
            assertThat(memberInformations.get(i).getGpa()).isEqualTo(gpa);
            assertThat(memberInformations.get(i).getSpecialtySkill()).isEqualTo(specialtySkill);
            assertThat(memberInformations.get(i).getHobby()).isEqualTo(hobby);
            assertThat(memberInformations.get(i).getMbti()).isEqualTo(mbti);
            assertThat(memberInformations.get(i).getAdvantage()).isEqualTo(advantage);
            assertThat(memberInformations.get(i).getDisadvantage()).isEqualTo(disadvantage);
            assertThat(memberInformations.get(i).getIntroduction()).isEqualTo(introduction);
            assertThat(memberInformations.get(i).getPhoto()).isEqualTo(photo);
        }
    }
}