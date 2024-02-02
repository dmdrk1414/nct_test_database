package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constant.LongVacation;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 회원들의 출석시간을 월, 화, 수 목, 금요일에 지정할 수 있다.
 */
@Data
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

    @ColumnDefault("10")
    @Column(name = "monday", length = 10)
    private String monday;

    @ColumnDefault("10")
    @Column(name = "tuesday", length = 10)
    private String tuesday;

    @ColumnDefault("10")
    @Column(name = "wednesday", length = 10)
    private String wednesday;

    @ColumnDefault("10")
    @Column(name = "thursday", length = 10)
    private String thursday;

    @ColumnDefault("10")
    @Column(name = "friday", length = 10)
    private String friday;

    @Enumerated(EnumType.STRING)
    @Column(name = "long_vacation", length = 15, nullable = false)
    private LongVacation longVacation;

    @Builder
    public AttendanceCheckTime(String monday, String tuesday, String wednesday, String thursday, String friday, LongVacation longVacation) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.longVacation = longVacation;
    }
}
