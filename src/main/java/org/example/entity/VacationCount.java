package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "vacation_count")
@DynamicInsert // insert할시 Null 배제
@DynamicUpdate // update할시 Null 배재
public class VacationCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_count_id")
    private Long vacationCountId;

    @ColumnDefault(value = "5")
    @Column(name = "vacation_count")
    private Integer vacationCount;

    @Column(name = "vacation_count_date", length = 15, nullable = false)
    private String vacationCountDate;

    @Builder
    public VacationCount(Integer vacationCount) {
        this.vacationCount = vacationCount;
    }

    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.vacationCountDate = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    public void updateVacationCount(Integer vacationCount) {
        this.vacationCount = vacationCount;
    }

    public void subtractVacationCount() {
        this.vacationCount = this.vacationCount - 1;
    }

    public void subtractVacationCount(Integer number) {
        this.vacationCount = this.vacationCount - number;
    }

    public void addVacationCount() {
        this.vacationCount = this.vacationCount + 1;
    }

    public void addVacationCount(Integer number) {
        this.vacationCount = this.vacationCount + number;
    }
}
