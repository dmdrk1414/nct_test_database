package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "first_name", length = 10, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "major", length = 20, nullable = false)
    private String major;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "student_id", length = 15, nullable = false)
    private String studentId;

    @Column(name = "registration", length = 10, nullable = false)
    private String registration;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_information_id", nullable = false)
    private MemberInformation memberInformation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_admin_id", nullable = false)
    private MemberAdmin memberAdmin;

    @Builder
    public Member(String firstName, String lastName, String phoneNumber, String major, LocalDate birthDate, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    public void setMemberInformation(final MemberInformation memberInformation) {
        if (memberInformation == null) {
            throw new IllegalArgumentException("Member information cannot be null.");
        }
        this.memberInformation = memberInformation;
    }

    public void setMemberAdmin(final MemberAdmin memberAdmin) {
        if (memberAdmin == null) {
            throw new IllegalArgumentException("Member information cannot be null.");
        }
        this.memberAdmin = memberAdmin;
    }

    public String getBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.registration = String.valueOf(zonedDateTime.toLocalDate().getYear());
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateMajor(String major) {
        this.major = major;
    }

    public void updateBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void updateStudentId(String studentId) {
        this.studentId = studentId;
    }
}
