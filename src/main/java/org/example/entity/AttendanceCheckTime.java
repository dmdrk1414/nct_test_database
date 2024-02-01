package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.ATTENDANCE_TIME;
import org.example.constant.LONG_VACATION;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 회원들의 출석시간을 월, 화, 수 목, 금요일에 지정할 수 있다.
 */
@Getter
@ToString
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "attendance_check_time")
public class AttendanceCheckTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_check_time_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "monday", length = 10)
    private ATTENDANCE_TIME monday;

    @Enumerated(EnumType.STRING)
    @Column(name = "tuesday", length = 10)
    private ATTENDANCE_TIME tuesday;

    @Enumerated(EnumType.STRING)
    @Column(name = "wednesday", length = 10)
    private ATTENDANCE_TIME wednesday;

    @Enumerated(EnumType.STRING)
    @Column(name = "thursday", length = 10)
    private ATTENDANCE_TIME thursday;

    @Enumerated(EnumType.STRING)
    @Column(name = "friday", length = 10)
    private ATTENDANCE_TIME friday;

    @Enumerated(EnumType.STRING)
    @Column(name = "long_vacation", length = 15, nullable = false)
    private LONG_VACATION longVacation;

    @Builder
    public AttendanceCheckTime(ATTENDANCE_TIME monday, ATTENDANCE_TIME tuesday, ATTENDANCE_TIME wednesday, ATTENDANCE_TIME thursday, ATTENDANCE_TIME friday, LONG_VACATION longVacation) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.longVacation = longVacation;
    }

    @PrePersist
    protected void onCreate() {
        this.monday = ATTENDANCE_TIME.TEN;
        this.tuesday = ATTENDANCE_TIME.TEN;
        this.wednesday = ATTENDANCE_TIME.TEN;
        this.thursday = ATTENDANCE_TIME.TEN;
        this.friday = ATTENDANCE_TIME.TEN;
    }
}
