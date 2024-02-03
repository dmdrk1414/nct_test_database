package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) // 추가
@Table(name = "base_entity")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_entity_id")
    private Long baseEntityId;

    @Column(name = "crt_date")
    @CreatedDate
    private LocalDateTime crtDt;

    @LastModifiedDate
    private LocalDateTime updatedDt;

    @Column(name = "crt_timestamp")
    @CreationTimestamp
    private LocalDateTime crt_timestamp;

    @Column(name = "udt_dt")
    @UpdateTimestamp
    private LocalDateTime udtDt;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "attendance_date")
//    private LocalDateTime attendanceDate;
//
//    @Temporal(TemporalType.TIME)
//    private LocalTime time;
//
//    @Temporal(TemporalType.DATE)
//    private LocalDate date;
//
//    @PrePersist
//    protected void onCreate() {
////        this.attendanceDate = LocalDate.now();
//        LocalDateTime dateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
//        this.attendanceDate = zonedDateTime.toLocalDateTime();
//        this.time = zonedDateTime.toLocalTime();
//        this.date = zonedDateTime.toLocalDate();

//      this.attendanceDate = LocalDate.now();
//    }
}
