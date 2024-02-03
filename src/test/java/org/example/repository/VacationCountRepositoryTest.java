package org.example.repository;

import org.example.entity.VacationCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class VacationCountRepositoryTest {
    private final VacationCountRepository vacationCountRepository;

    @Autowired
    VacationCountRepositoryTest(VacationCountRepository vacationCountRepository) {
        this.vacationCountRepository = vacationCountRepository;
    }

    @BeforeEach
    void setUp() {
        this.vacationCountRepository.deleteAll();
    }

    @Test
    void VacationCount_저장_테스트() {
        vacationCountRepository.save(new VacationCount());
    }

    @Test
    void VacationCount_저장_테스트_2() {
        vacationCountRepository.save(VacationCount.builder()
                .vacationCount(6)
                .build());
    }

    @Test
    void VacationCount_업데이트_테스트_2() {
        VacationCount vacationCount = vacationCountRepository.save(new VacationCount(5));
        // 1 빼기
        vacationCount.subtractVacationCount();

        VacationCount vacationCount1 = vacationCountRepository.save(vacationCount);
        assertThat(vacationCount1.getVacationCount()).isEqualTo(4);

        VacationCount vacationCount2 = vacationCountRepository.save(vacationCount);
        // 1 더하기
        vacationCount2.addVacationCount();

        VacationCount vacationCount3 = vacationCountRepository.save(vacationCount2);
        assertThat(vacationCount3.getVacationCount()).isEqualTo(5);

        vacationCount3.subtractVacationCount(3);
        VacationCount vacationCount4 = vacationCountRepository.save(vacationCount3);

        assertThat(vacationCount4.getVacationCount()).isEqualTo(2);
        VacationCount vacationCount5 = vacationCountRepository.save(vacationCount4);

        vacationCount5.addVacationCount(3);
        VacationCount vacationCount6 = vacationCountRepository.save(vacationCount5);

        assertThat(vacationCount6.getVacationCount()).isEqualTo(5);
    }
}