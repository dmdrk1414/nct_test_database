package org.example.repository;

import org.example.constant.TEST_ENUM;
import org.example.entity.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
@AutoConfigureMockMvc
class TestEntityRepositoryTest {
    private final TestEntityRepository testEntityRepository;

    @Autowired
    TestEntityRepositoryTest(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    @BeforeEach
    void setUp() {
        this.testEntityRepository.deleteAll();
    }

    @Test
    void Test_Entity_저장_테스트() {
        testEntityRepository.save(
                TestEntity.builder()
                        .testEnum(TEST_ENUM.TEST)
                        .build()
        );


    }
}