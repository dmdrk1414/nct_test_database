package org.example.repository;

import org.example.constant.ATTENDANCE_TIME;
import org.example.constant.LONG_VACATION;
import org.example.entity.AttendanceCheckTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class AttendanceCheckTimeRepositoryTest {
    private final AttendanceCheckTimeRepository attendanceCheckTimeRepository;

    @Autowired
    AttendanceCheckTimeRepositoryTest(AttendanceCheckTimeRepository attendanceNumberRepository) {
        this.attendanceCheckTimeRepository = attendanceNumberRepository;
    }

    @BeforeEach
    void setUp() {
        attendanceCheckTimeRepository.deleteAll();
    }

    @Test
    void AttendanceCheckTime_저장_테스트() {
        for (int i = 0; i < 10; i++) {
            attendanceCheckTimeRepository.save(AttendanceCheckTime.builder()
                    .longVacation(LONG_VACATION.NOT_APPLIED)
                    .build());
        }
        for (int i = 0; i < 10; i++) {
            attendanceCheckTimeRepository.save(AttendanceCheckTime.builder()
                    .longVacation(LONG_VACATION.APPLIED)
                    .build());
        }
        List<AttendanceCheckTime> attendanceCheckTimes = attendanceCheckTimeRepository.findAll();

        for (int i = 0; i < 10; i++) {
            assertThat(attendanceCheckTimes.get(i).getLongVacation()).isEqualTo(LONG_VACATION.NOT_APPLIED);
        }
        for (int i = 10; i < attendanceCheckTimes.size(); i++) {
            assertThat(attendanceCheckTimes.get(i).getLongVacation()).isEqualTo(LONG_VACATION.NOT_APPLIED);
        }

        for (int i = 0; i < 20; i++) {
            assertThat(attendanceCheckTimes.get(i).getMonday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getTuesday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getWednesday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getThursday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getFriday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getSaturday()).isEqualTo(ATTENDANCE_TIME.TEN);
            assertThat(attendanceCheckTimes.get(i).getSunday()).isEqualTo(ATTENDANCE_TIME.TEN);
        }
    }

    @Test
    void AttendanceCheckTime_업데이트_테스트() {
        AttendanceCheckTime attendanceCheckTime = attendanceCheckTimeRepository.save(AttendanceCheckTime.builder()
                .build());

        attendanceCheckTime.updateMonday(ATTENDANCE_TIME.FIFTEEN);
        attendanceCheckTime.updateTuesday(ATTENDANCE_TIME.SIXTEEN);
        attendanceCheckTime.updateWednesday(ATTENDANCE_TIME.SEVENTEEN);
        attendanceCheckTime.updateThursday(ATTENDANCE_TIME.EIGHTEEN);
        attendanceCheckTime.updateFriday(ATTENDANCE_TIME.NINETEEN);
        attendanceCheckTime.updateSaturday(ATTENDANCE_TIME.NINETEEN);
        attendanceCheckTime.updateSunday(ATTENDANCE_TIME.NINETEEN);

        attendanceCheckTime.updateLongVacation(LONG_VACATION.APPLIED);

        AttendanceCheckTime target = attendanceCheckTimeRepository.save(attendanceCheckTime);
        assertThat(target.getMonday()).isEqualTo(ATTENDANCE_TIME.FIFTEEN);
        assertThat(target.getTuesday()).isEqualTo(ATTENDANCE_TIME.SIXTEEN);
        assertThat(target.getWednesday()).isEqualTo(ATTENDANCE_TIME.SEVENTEEN);
        assertThat(target.getThursday()).isEqualTo(ATTENDANCE_TIME.EIGHTEEN);
        assertThat(target.getFriday()).isEqualTo(ATTENDANCE_TIME.NINETEEN);
        assertThat(target.getSaturday()).isEqualTo(ATTENDANCE_TIME.NINETEEN);
        assertThat(target.getSunday()).isEqualTo(ATTENDANCE_TIME.NINETEEN);

        assertThat(target.getLongVacation()).isEqualTo(LONG_VACATION.APPLIED);
    }
}