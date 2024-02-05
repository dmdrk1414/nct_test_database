package org.example.testutill;

import org.example.constant.MBTI;
import org.example.constant.MEMBER_GRADE;
import org.example.entity.Member;
import org.example.entity.MemberAdmin;
import org.example.entity.MemberInformation;
import org.example.myutill.CustomLocalDate;
import org.example.repository.MemberInformationRepository;
import org.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

public class TestSetUp {

    public static MemberInformation getMemberInformation() {
        String gpa = "4.5";
        String hobby = "달리기";
        String photo = "사진";
        String specialtySkill = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String advantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String disadvantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
        String introduction = "200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 ";
        MBTI mbti = MBTI.ENTP;

        return MemberInformation.builder()
                .gpa(gpa)
                .specialtySkill(specialtySkill)
                .hobby(hobby)
                .mbti(mbti)
                .advantage(advantage)
                .disadvantage(disadvantage)
                .introduction(introduction)
                .photo(photo)
                .build();
    }

    public static Member getMember() {
        return Member.builder()
                .firstName("박")
                .lastName("승찬")
                .phoneNumber("010-0000-0000")
                .major("컴퓨터공학과")
                .birthDate(CustomLocalDate.parse2BirthDateFromString("1996-04-15"))
                .studentId("20249999")
                .build();
    }

    public static MemberAdmin getMemberAdmin() {
        String email = "test@test.com";
        String password = "1234";
        MEMBER_GRADE memberGrade = MEMBER_GRADE.MEMBER;

        return MemberAdmin.builder()
                .email(email)
                .password(password)
                .grade(memberGrade)
                .build();
    }
}
