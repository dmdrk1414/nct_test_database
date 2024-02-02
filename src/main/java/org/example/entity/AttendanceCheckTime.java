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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
