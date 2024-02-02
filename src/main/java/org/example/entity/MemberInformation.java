package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constant.MBTI;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Data
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
}
