package org.example.repository;

import org.example.entity.ArticleComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class ArticleCommentRepositoryTest {
    private final ArticleCommentRepository articleCommentRepository;

    @Autowired
    ArticleCommentRepositoryTest(ArticleCommentRepository articleCommentRepository) {
        this.articleCommentRepository = articleCommentRepository;
    }

    @BeforeEach
    void setUp() {
        articleCommentRepository.deleteAll();
    }

    @Test
    void ArticleComment_저장_테스트() {
        String CONTENT = "TEST CONTENT";

        ArticleComment articleComment = articleCommentRepository.save(ArticleComment.builder()
                .content(CONTENT)
                .build());

        ArticleComment target = articleCommentRepository.findById(articleComment.getArticleCommentId()).get();

        assertThat(target.getContent()).isEqualTo(CONTENT);
    }
}