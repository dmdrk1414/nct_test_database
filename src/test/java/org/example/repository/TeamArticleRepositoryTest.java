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
    private final TeamArticleRepository teamArticleRepository;

    @Autowired
    TeamArticleRepositoryTest(TeamArticleRepository teamArticleRepository) {
        this.teamArticleRepository = teamArticleRepository;
    }

    @BeforeEach
    void setUp() {
        this.teamArticleRepository.deleteAll();
    }

    @Test
    void TeamArticle_저장_테스트() {
        String title = "test title";
        String content = "test content";

        TeamArticle teamArticle = teamArticleRepository.save(TeamArticle.builder()
                .title(title)
                .content(content)
                .build());

        TeamArticle teamArticle1 = teamArticleRepository.findById(teamArticle.getTeamArticleId()).get();
        assertThat(teamArticle1.getTitle()).isEqualTo(title);
        assertThat(teamArticle1.getContent()).isEqualTo(content);
        assertThat(teamArticle1.getAnswerCheck()).isEqualTo(TEAM_ARTICLE_CHECK.UNCONFIRMED);
        assertThat(teamArticle1.getLikeCount()).isEqualTo(0);
    }

    @Test
    void Suggestion_업데이트_테스트() {
        String title = "test title";
        String content = "test content";
        String updateTitle = "update title";
        String updateContent = "update content";

        TeamArticle teamArticle = teamArticleRepository.save(TeamArticle.builder()
                .title(title)
                .content(content)
                .build());

        teamArticle.updateTitle(updateTitle);
        teamArticle.updateContent(updateContent);
        teamArticle.updateAnswerCheck(TEAM_ARTICLE_CHECK.CONFIRMED);

        TeamArticle teamArticle1 = teamArticleRepository.save(teamArticle);
        assertThat(teamArticle1.getTitle()).isEqualTo(updateTitle);
        assertThat(teamArticle1.getContent()).isEqualTo(updateContent);
        assertThat(teamArticle1.getAnswerCheck()).isEqualTo(TEAM_ARTICLE_CHECK.CONFIRMED);
    }
}