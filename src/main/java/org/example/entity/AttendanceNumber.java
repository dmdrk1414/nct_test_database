package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Column(name = "attendance_date")
    private Date attendanceDate;


    @PrePersist
    protected void onCreate() {
        this.attendanceDate = new Date();
    }
}
