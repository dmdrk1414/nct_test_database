package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.*;
import org.example.constant.MBTI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 스터디 팀에 참가를 원하는 신입 회원을 위한 테이블
 */
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "temp_member")
public class TempMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_member_id")
    private Long tempMemberId;

    @Column(name = "first_name", length = 10, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "major", length = 20, nullable = false)
    private String major;

    @Column(name = "gpa", length = 10, nullable = false)
    private String gpa;

    @Column(name = "specialty_skill", length = 255, nullable = false)
    private String specialtySkill;

    @Column(name = "hobby", length = 255, nullable = false)
    private String hobby;

    @Enumerated(EnumType.STRING)
    @Column(name = "mbti", length = 10, nullable = false)
    private MBTI mbti;

    @Column(name = "student_id", length = 15, nullable = false)
    private String studentId;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "advantage", length = 1000, nullable = false)
    private String advantage;

    @Column(name = "disadvantage", length = 1000, nullable = false)
    private String disadvantage;

    @Column(name = "introduction", length = 1000, nullable = false)
    private String introduction;

    @Column(name = "photo", length = 255, nullable = false)
    private String photo;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Builder
    public TempMember(String firstName, String lastName, String phoneNumber, String major, String gpa, String specialtySkill, String hobby, MBTI mbti, String studentId, LocalDate birthDate, String advantage, String disadvantage, String introduction, String photo, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.gpa = gpa;
        this.specialtySkill = specialtySkill;
        this.hobby = hobby;
        this.mbti = mbti;
        this.studentId = studentId;
        this.birthDate = birthDate;
        this.advantage = advantage;
        this.disadvantage = disadvantage;
        this.introduction = introduction;
        this.photo = photo;
        this.email = email;
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
