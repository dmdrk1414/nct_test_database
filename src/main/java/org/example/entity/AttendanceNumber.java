package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.time.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert //애노테이션은 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다
@Table(name = "attendance_number")
public class AttendanceNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_number_id")
    private Long attendanceNumberId;

    @Column(name = "attendance_number", length = 10, nullable = false)
    private String attendanceNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.attendanceDate = zonedDateTime.toLocalDate();
    }
}
