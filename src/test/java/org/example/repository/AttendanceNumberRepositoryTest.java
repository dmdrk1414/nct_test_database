package org.example.repository;

import org.example.entity.AttendanceNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
        attendanceNumberRepository.save(
                AttendanceNumber.builder()
                        .attendanceNumber("1234")
                        .build()
        );

        System.out.println("new Date() = " + new Date());
    }
}