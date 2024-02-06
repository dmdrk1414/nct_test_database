package org.example.repository;

import org.example.constant.TEAM_ARTICLE_CHECK;
import org.example.entity.TeamArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class TeamArticleRepositoryTest {
    private final TeamArticleRepository suggestionRepository;

    @Autowired
    TeamArticleRepositoryTest(TeamArticleRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    @BeforeEach
    void setUp() {
        this.suggestionRepository.deleteAll();
    }

    @Test
    void Suggestion_저장_테스트() {
        String title = "test title";
        String content = "test content";

        TeamArticle suggestion = suggestionRepository.save(TeamArticle.builder()
                .title(title)
                .content(content)
                .build());

        assertThat(suggestion.getTitle()).isEqualTo(title);
        assertThat(suggestion.getContent()).isEqualTo(content);
        assertThat(suggestion.getCheck()).isEqualTo(TEAM_ARTICLE_CHECK.UNCONFIRMED);
    }

    @Test
    void Suggestion_업데이트_테스트() {
        String title = "test title";
        String content = "test content";
        String updateTitle = "update title";
        String updateContent = "update content";

        TeamArticle suggestion = suggestionRepository.save(TeamArticle.builder()
                .title(title)
                .content(content)
                .build());

        suggestion.updateTitle(updateTitle);
        suggestion.updateContent(updateContent);
        suggestion.updateCheck(TEAM_ARTICLE_CHECK.CONFIRMED);
        TeamArticle suggestion1 = suggestionRepository.save(suggestion);
        assertThat(suggestion1.getTitle()).isEqualTo(updateTitle);
        assertThat(suggestion1.getContent()).isEqualTo(updateContent);
        assertThat(suggestion1.getCheck()).isEqualTo(TEAM_ARTICLE_CHECK.CONFIRMED);
    }
}