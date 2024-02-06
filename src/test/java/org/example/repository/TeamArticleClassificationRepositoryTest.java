package org.example.repository;

import org.example.constant.TEAM_ARTICLE_CLASSIFICATION;
import org.example.entity.TeamArticleClassification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class TeamArticleClassificationRepositoryTest {
    private final TeamArticleClassificationRepository suggestionClassificationRepository;

    @Autowired
    TeamArticleClassificationRepositoryTest(TeamArticleClassificationRepository suggestionClassificationRepository) {
        this.suggestionClassificationRepository = suggestionClassificationRepository;
    }

    @BeforeEach
    void setUp() {
        this.suggestionClassificationRepository.deleteAll();
    }

    @Test
    void SuggestionClassification_저장_테스트() {
        suggestionClassificationRepository.save(
                TeamArticleClassification.builder()
                        .classification(TEAM_ARTICLE_CLASSIFICATION.FREEDOM)
                        .build()
        );

        suggestionClassificationRepository.save(
                TeamArticleClassification.builder()
                        .classification(TEAM_ARTICLE_CLASSIFICATION.SUGGESTION)
                        .build()
        );

        suggestionClassificationRepository.save(
                TeamArticleClassification.builder()
                        .classification(TEAM_ARTICLE_CLASSIFICATION.CONFIDENTIAL)
                        .build()
        );

        List<TeamArticleClassification> list = suggestionClassificationRepository.findAll();

        assertThat(list.get(0).getClassification()).isEqualTo(TEAM_ARTICLE_CLASSIFICATION.FREEDOM);
        assertThat(list.get(1).getClassification()).isEqualTo(TEAM_ARTICLE_CLASSIFICATION.SUGGESTION);
        assertThat(list.get(2).getClassification()).isEqualTo(TEAM_ARTICLE_CLASSIFICATION.CONFIDENTIAL);
    }
}