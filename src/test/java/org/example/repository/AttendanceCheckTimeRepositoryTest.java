package org.example.repository;

import org.example.constant.LongVacation;
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
                    .longVacation(LongVacation.NOT_APPLIED)
                    .build());
        }
        for (int i = 0; i < 10; i++) {
            attendanceCheckTimeRepository.save(AttendanceCheckTime.builder()
                    .longVacation(LongVacation.APPLIED)
                    .build());
        }
        List<AttendanceCheckTime> attendanceCheckTimes = attendanceCheckTimeRepository.findAll();

        for (int i = 0; i < 10; i++) {
            assertThat(attendanceCheckTimes.get(i).getLongVacation()).isEqualTo(LongVacation.NOT_APPLIED);
        }
        for (int i = 10; i < attendanceCheckTimes.size(); i++) {
            assertThat(attendanceCheckTimes.get(i).getLongVacation()).isEqualTo(LongVacation.APPLIED);
        }
    }
}