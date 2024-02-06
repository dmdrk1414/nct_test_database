package org.example.repository;

import org.example.entity.TeamArticleComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class TeamArticleCommentRepositoryTest {
    private final TeamArticleCommentRepository suggestionCommentRepository;

    @Autowired
    TeamArticleCommentRepositoryTest(TeamArticleCommentRepository suggestionCommentRepository) {
        this.suggestionCommentRepository = suggestionCommentRepository;
    }

    @BeforeEach
    void setUp() {
        this.suggestionCommentRepository.deleteAll();
    }

    @Test
    void SuggestionComment_저장_테스트() {
        String content = "test content";

        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        String date = String.valueOf(zonedDateTime.toLocalDate());

        TeamArticleComment suggestionComment = suggestionCommentRepository.save(
                TeamArticleComment.builder()
                        .content(content)
                        .build()
        );
        TeamArticleComment target = suggestionCommentRepository.findById(suggestionComment.getTeamArticleCommentId()).get();

        assertThat(target.getContent()).isEqualTo(content);
        assertThat(target.getLikeCount()).isEqualTo(0);
        assertThat(target.getCommentDate()).isEqualTo(date);
    }

    @Test
    void SuggestionComment_업데이트_테스트() {
        String content = "test content";
        String updateContent = "update content";

        TeamArticleComment suggestionComment = suggestionCommentRepository.save(
                TeamArticleComment.builder()
                        .content(content)
                        .build()
        );
        TeamArticleComment suggestionComment1 = suggestionCommentRepository.findById(suggestionComment.getTeamArticleCommentId()).get();
        suggestionComment1.updateContent(updateContent);
        suggestionComment1.addLike();

        TeamArticleComment target = suggestionCommentRepository.save(suggestionComment1);

        assertThat(target.getContent()).isEqualTo(updateContent);
        assertThat(target.getLikeCount()).isEqualTo(1);
    }
}