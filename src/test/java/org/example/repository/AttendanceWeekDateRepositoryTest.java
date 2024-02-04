package org.example.repository;

import org.example.constant.ATTENDANCE_STATE;
import org.example.entity.AttendanceWeekDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class AttendanceWeekDateRepositoryTest {
    private final AttendanceWeekDateRepository attendanceWeekDateRepository;
    AttendanceWeekDate attendanceWeekDate;

    @Autowired
    AttendanceWeekDateRepositoryTest(AttendanceWeekDateRepository attendanceWeekDateRepository) {
        this.attendanceWeekDateRepository = attendanceWeekDateRepository;
    }

    @BeforeEach
    void setUp() {
        this.attendanceWeekDateRepository.deleteAll();
    }

    @Test
    void AttendanceWeekDate_저장_테스트() {
        assertThat(attendanceWeekDateRepository.count()).isEqualTo(0);
        AttendanceWeekDate attendanceWeekDate = attendanceWeekDateRepository.save(
                AttendanceWeekDate.builder().build()
        );
        assertThat(attendanceWeekDateRepository.count()).isEqualTo(1);
    }

    @Test
    void AttendanceWeekDate_금일_출석_업데이트_테스트() {
        AttendanceWeekDate attendanceWeekDate = attendanceWeekDateRepository.save(
                AttendanceWeekDate.builder().build()
        );

        attendanceWeekDate.updateAttendanceAtToday();
        AttendanceWeekDate attendanceWeekDate1 = attendanceWeekDateRepository.save(attendanceWeekDate);

        ZonedDateTime now = ZonedDateTime.now();
        DayOfWeek currentDayOfWeek = now.getDayOfWeek();

        switch (currentDayOfWeek) {
            case MONDAY:
                assertThat(attendanceWeekDate1.getMonday()).isEqualTo(ATTENDANCE_STATE.ATTENDANCE);
                break;
            case TUESDAY:
                assertThat(attendanceWeekDate1.getTuesday()).isEqualTo(ATTENDANCE_STATE.ATTENDANCE);
                break;
            case WEDNESDAY:
                assertThat(attendanceWeekDate1.getWednesday()).isEqualTo(ATTENDANCE_STATE.ATTENDANCE);
                break;
            case THURSDAY:
                assertThat(attendanceWeekDate1.getThursday()).isEqualTo(ATTENDANCE_STATE.ATTENDANCE);
                break;
            case FRIDAY:
                assertThat(attendanceWeekDate1.getFriday()).isEqualTo(ATTENDANCE_STATE.ATTENDANCE);
                break;
            default:
                break;
        }
    }

    @Test
    void AttendanceWeekDate_금일_결석_업데이트_테스트() {
        AttendanceWeekDate attendanceWeekDate = attendanceWeekDateRepository.save(
                AttendanceWeekDate.builder().build()
        );

        attendanceWeekDate.updateAbsenceAtToday();
        AttendanceWeekDate attendanceWeekDate1 = attendanceWeekDateRepository.save(attendanceWeekDate);

        ZonedDateTime now = ZonedDateTime.now();
        DayOfWeek currentDayOfWeek = now.getDayOfWeek();

        switch (currentDayOfWeek) {
            case MONDAY:
                assertThat(attendanceWeekDate1.getMonday()).isEqualTo(ATTENDANCE_STATE.ABSENCE);
                break;
            case TUESDAY:
                assertThat(attendanceWeekDate1.getTuesday()).isEqualTo(ATTENDANCE_STATE.ABSENCE);
                break;
            case WEDNESDAY:
                assertThat(attendanceWeekDate1.getWednesday()).isEqualTo(ATTENDANCE_STATE.ABSENCE);
                break;
            case THURSDAY:
                assertThat(attendanceWeekDate1.getThursday()).isEqualTo(ATTENDANCE_STATE.ABSENCE);
                break;
            case FRIDAY:
                assertThat(attendanceWeekDate1.getFriday()).isEqualTo(ATTENDANCE_STATE.ABSENCE);
                break;
            default:
                break;
        }
    }

    @Test
    void AttendanceWeekDate_금일_방학_업데이트_테스트() {
        AttendanceWeekDate attendanceWeekDate = attendanceWeekDateRepository.save(
                AttendanceWeekDate.builder().build()
        );

        attendanceWeekDate.updateVacationAtToday();
        AttendanceWeekDate attendanceWeekDate1 = attendanceWeekDateRepository.save(attendanceWeekDate);

        ZonedDateTime now = ZonedDateTime.now();
        DayOfWeek currentDayOfWeek = now.getDayOfWeek();

        switch (currentDayOfWeek) {
            case MONDAY:
                assertThat(attendanceWeekDate1.getMonday()).isEqualTo(ATTENDANCE_STATE.VACATION);
                break;
            case TUESDAY:
                assertThat(attendanceWeekDate1.getTuesday()).isEqualTo(ATTENDANCE_STATE.VACATION);
                break;
            case WEDNESDAY:
                assertThat(attendanceWeekDate1.getWednesday()).isEqualTo(ATTENDANCE_STATE.VACATION);
                break;
            case THURSDAY:
                assertThat(attendanceWeekDate1.getThursday()).isEqualTo(ATTENDANCE_STATE.VACATION);
                break;
            case FRIDAY:
                assertThat(attendanceWeekDate1.getFriday()).isEqualTo(ATTENDANCE_STATE.VACATION);
                break;
            default:
                break;
        }
    }
}