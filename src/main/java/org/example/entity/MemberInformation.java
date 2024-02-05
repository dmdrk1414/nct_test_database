package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.MBTI;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "member_information")
public class MemberInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_information_id")
    private Long memberInformationId;

    @Column(name = "gpa", length = 10, nullable = false)
    private String gpa;

    @Enumerated(EnumType.STRING)
    @Column(name = "mbti", length = 10, nullable = false)
    private MBTI mbti;

    @Column(name = "hobby", length = 255, nullable = false)
    private String hobby;

    @Column(name = "specialty_skill", length = 255, nullable = false)
    private String specialtySkill;

    @Column(name = "advantage", length = 1000, nullable = false)
    private String advantage;

    @Column(name = "disadvantage", length = 1000, nullable = false)
    private String disadvantage;

    @Column(name = "introduction", length = 1000, nullable = false)
    private String introduction;

    @Column(name = "photo", length = 255, nullable = false)
    private String photo;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "memberInformation")
    private Member member;

    @Builder
    public MemberInformation(String gpa, MBTI mbti, String hobby, String specialtySkill, String advantage, String disadvantage, String introduction, String photo) {
        this.gpa = gpa;
        this.mbti = mbti;
        this.hobby = hobby;
        this.specialtySkill = specialtySkill;
        this.advantage = advantage;
        this.disadvantage = disadvantage;
        this.introduction = introduction;
        this.photo = photo;
    }

    public void setMember(final Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member information cannot be null.");
        }
        this.member = member;
    }

    public void updateGpa(String gpa) {
        this.gpa = gpa;
    }

    public void updateMbti(MBTI mbti) {
        this.mbti = mbti;
    }

    public void updateHobby(String hobby) {
        this.hobby = hobby;
    }

    public void updateSpecialtySkill(String specialtySkill) {
        this.specialtySkill = specialtySkill;
    }

    public void updateAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public void updateDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage;
    }

    public void updateIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void updatePhoto(String photo) {
        this.photo = photo;
    }
}
