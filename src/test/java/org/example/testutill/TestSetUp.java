package org.example.testutill;

import org.example.constant.MBTI;
import org.example.constant.MEMBER_GRADE;
import org.example.entity.Member;
import org.example.myutill.CustomLocalDate;

public class TestSetUp {

    //    public static MemberInformation getMemberInformation() {
//        String gpa = "4.5";
//        String hobby = "달리기";
//        String photo = "사진";
//        String specialtySkill = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
//        String advantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
//        String disadvantage = "100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 100자테스트 ";
//        String introduction = "200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 200자테스트 ";
//        MBTI mbti = MBTI.ENTP;
//
//        return MemberInformation.builder()
//                .gpa(gpa)
//                .specialtySkill(specialtySkill)
//                .hobby(hobby)
//                .mbti(mbti)
//                .advantage(advantage)
//                .disadvantage(disadvantage)
//                .introduction(introduction)
//                .photo(photo)
//                .build();
//    }
//
    public static Member getRepresentativMember() {
        String FIRST_NAME = "박";
        String LAST_NAME = "승찬";
        String NICK_NAME = "박";
        String EMAIL = "test1234@test.com";
        String MAJOR = "컴퓨터공학과";
        String STUDENT_ID = "20240101";
        return Member.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .nickName(NICK_NAME)
                .email(EMAIL)
                .major(MAJOR)
                .studentId(STUDENT_ID)
                .build();
    }
//
//    public static MemberAdmin getMemberAdmin() {
//        String email = "test@test.com";
//        String password = "1234";
//        MEMBER_GRADE memberGrade = MEMBER_GRADE.MEMBER;
//
//        return MemberAdmin.builder()
//                .email(email)
//                .password(password)
//                .grade(memberGrade)
//                .build();
//    }
}
