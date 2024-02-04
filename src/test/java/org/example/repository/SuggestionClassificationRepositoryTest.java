package org.example.repository;

import org.example.constant.SUGGESTION_CLASSIFICATION;
import org.example.entity.SuggestionClassification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class SuggestionClassificationRepositoryTest {
    private final SuggestionClassificationRepository suggestionClassificationRepository;

    @Autowired
    SuggestionClassificationRepositoryTest(SuggestionClassificationRepository suggestionClassificationRepository) {
        this.suggestionClassificationRepository = suggestionClassificationRepository;
    }

    @BeforeEach
    void setUp() {
        this.suggestionClassificationRepository.deleteAll();
    }

    @Test
    void SuggestionClassification_저장_테스트() {
        suggestionClassificationRepository.save(
                SuggestionClassification.builder()
                        .classification(SUGGESTION_CLASSIFICATION.FREEDOM)
                        .build()
        );

        suggestionClassificationRepository.save(
                SuggestionClassification.builder()
                        .classification(SUGGESTION_CLASSIFICATION.SUGGESTION)
                        .build()
        );

        suggestionClassificationRepository.save(
                SuggestionClassification.builder()
                        .classification(SUGGESTION_CLASSIFICATION.CONFIDENTIAL)
                        .build()
        );

        List<SuggestionClassification> list = suggestionClassificationRepository.findAll();

        assertThat(list.get(0).getClassification()).isEqualTo(SUGGESTION_CLASSIFICATION.FREEDOM);
        assertThat(list.get(1).getClassification()).isEqualTo(SUGGESTION_CLASSIFICATION.SUGGESTION);
        assertThat(list.get(2).getClassification()).isEqualTo(SUGGESTION_CLASSIFICATION.CONFIDENTIAL);
    }
}