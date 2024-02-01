package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "student_id", length = 15, nullable = false)
    private String studentId;

    @Column(name = "registration", length = 10, nullable = false)
    private String registration;


    @Builder
    public Member(String firstName, String lastName, String phoneNumber, String major, LocalDate birthDate, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }


    public String getBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        // TODO: 2/2/24 날짜 확인
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
