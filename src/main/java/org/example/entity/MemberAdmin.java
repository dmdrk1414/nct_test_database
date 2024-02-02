package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constant.MEMBER_GRADE;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 회원의 등급과, 이메일, 비밀번호를 관리한다.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "member_admin")
public class MemberAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_admin_id")
    private Long tempMemberId;

    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", length = 15, nullable = false)
    private MEMBER_GRADE grade;

    @Builder
    public MemberAdmin(String email, String password, MEMBER_GRADE grade) {
        this.email = email;
        this.password = password;
        this.grade = grade;
    }
}
