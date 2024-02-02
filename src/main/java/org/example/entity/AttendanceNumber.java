package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 * 모든 팀들의 회원들이 출석을 하기위한 출석 번호
 * 랜덤으로 4자리 1~9의 숫자가 생성된다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "attendance_number")
public class AttendanceNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_number_id")
    private Long attendanceNumberId;

    @Column(name = "attendance_number", length = 10, nullable = false)
    private String attendanceNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    public String getAttendanceDate() {
        return attendanceDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.attendanceDate = zonedDateTime.toLocalDate();

        // 1부터 9까지 랜덤한 4자리 숫자 생성
        int randomAttendanceNumber = (int) (Math.random() * 9_000) + 1_000;
        this.attendanceNumber = String.valueOf(randomAttendanceNumber);
    }
}
