package org.example.repository;

import org.example.entity.AttendanceNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class AttendanceNumberRepositoryTest {
    private final AttendanceNumberRepository attendanceNumberRepository;

    @Autowired
    AttendanceNumberRepositoryTest(AttendanceNumberRepository attendanceNumberRepository) {
        this.attendanceNumberRepository = attendanceNumberRepository;
    }

    @BeforeEach
    void setUp() {
        attendanceNumberRepository.deleteAll();
    }

    @Test
    void AttendanceNumber_저장_테스트() {
//        LocalDateTime dateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));

        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();

        // 원하는 형식의 문자열로 포맷팅하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        for (int i = 0; i < 100; i++) {
            attendanceNumberRepository.save(new AttendanceNumber());
        }

        List<AttendanceNumber> attendanceNumbers = attendanceNumberRepository.findAll();
        for (AttendanceNumber attendanceNumber : attendanceNumbers) {
            assertThat(attendanceNumber.getAttendanceDate()).isEqualTo(formattedDate);
            assertThat(attendanceNumber.getAttendanceNumber().length()).isEqualTo(4);
        }
    }

}