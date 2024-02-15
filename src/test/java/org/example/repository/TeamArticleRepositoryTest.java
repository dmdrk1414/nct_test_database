package org.example.repository;

import org.example.constant.TEAM_ARTICLE_CHECK;
import org.example.entity.TeamArticle;
import org.example.entity.TeamArticleClassification;
import org.example.entity.TeamArticleComment;
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
    private final TeamArticleClassificationRepository teamArticleClassificationRepository;
    private final TeamArticleCommentRepository teamArticleCommentRepository;

    @Autowired
    TeamArticleRepositoryTest(TeamArticleRepository teamArticleRepository, TeamArticleClassificationRepository teamArticleClassificationRepository, TeamArticleCommentRepository teamArticleCommentRepository) {
        this.teamArticleRepository = teamArticleRepository;
        this.teamArticleClassificationRepository = teamArticleClassificationRepository;
        this.teamArticleCommentRepository = teamArticleCommentRepository;
    }

    @BeforeEach
    void setUp() {
        this.teamArticleRepository.deleteAll();
        this.teamArticleCommentRepository.deleteAll();
    }

    @Test
    void TeamArticle_저장_테스트() {
        // TeamArticle - TeamArticleClassfication
        //             \- TeamArticleComment
        String title = "test title";
        String content = "test content";


        // 2.TeamArticleComment
        TeamArticleComment teamArticleComment_1 = TeamArticleComment.builder()
                .content("test Team Article Comment_1")
                .build();
        TeamArticleComment teamArticleComment_2 = TeamArticleComment.builder()
                .content("test Team Article Comment_2")
                .build();
        TeamArticleComment teamArticleComment_3 = TeamArticleComment.builder()
                .content("test Team Article Comment_3")
                .build();

        //        // JPA 영속성
        TeamArticle teamArticle_1 = teamArticleRepository.save(
                TeamArticle.builder()
                        .title(title)
                        .content(content)
                        .build()
        );


        teamArticle_1.addTeamArticleComment(teamArticleComment_1);
        teamArticle_1.addTeamArticleComment(teamArticleComment_2);
        teamArticle_1.addTeamArticleComment(teamArticleComment_3);
//
        teamArticleRepository.save(teamArticle_1);

        // UPDATE 테스트
        TeamArticle target_team_article = teamArticleRepository.findById(teamArticle_1.getTeamArticleId()).get();

        target_team_article.updateContent("UPDATE CONTENT");

        teamArticleRepository.save(target_team_article);


        // 1.TeamArticleClassfication
//        TeamArticleClassification teamArticleClassification = teamArticleClassificationRepository.findById(1L).get();
//        teamArticleClassification.addTeamArticle(teamArticle_1);

//        teamArticleClassificationRepository.save(teamArticleClassification);

//        TeamArticle teamArticle1 = teamArticleRepository.findById(teamArticle_1.getTeamArticleId()).get();
//        assertThat(teamArticle1.getTitle()).isEqualTo(title);
//        assertThat(teamArticle1.getContent()).isEqualTo(content);
//        assertThat(teamArticle1.getAnswerCheck()).isEqualTo(TEAM_ARTICLE_CHECK.UNCONFIRMED);
//        assertThat(teamArticle1.getLikeCount()).isEqualTo(0);
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