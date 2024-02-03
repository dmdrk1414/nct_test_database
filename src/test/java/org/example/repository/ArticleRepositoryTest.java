package org.example.repository;

import org.example.entity.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest()
@AutoConfigureMockMvc
class ArticleRepositoryTest {
    private final ArticleRepository articleRepository;

    @Autowired
    ArticleRepositoryTest(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @BeforeEach
    void setUp() {
        this.articleRepository.deleteAll();
    }

    @Test
    void Article_저장_테스트() {
        String title = "test title";
        String content = "test conten";
        for (int i = 0; i < 10; i++) {
            this.articleRepository.save(Article.builder()
                    .title(title)
                    .content(content)
                    .build());
        }
    }

    @Test
    void Article_신고_업데이트_테스트() {
        String title = "test title";
        String content = "test conten";
        Article article = this.articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        Article article0 = this.articleRepository.findById(article.getArticleId()).get();

        article0.addDeclaration();
        Article article1 = this.articleRepository.save(article0);
        assertThat(article1.getDeclarationCount()).isEqualTo(1);

        Article article2 = this.articleRepository.save(article1);
        article2.subtractDeclaration();
        Article article3 = this.articleRepository.save(article2);
        assertThat(article3.getDeclarationCount()).isEqualTo(0);

        article3.subtractDeclaration();
        Article article4 = this.articleRepository.save(article3);
        assertThat(article4.getDeclarationCount()).isEqualTo(0);

    }

    @Test
    void Article_좋아요_업데이트_테스트() {
        String title = "test title";
        String content = "test conten";
        Article article = this.articleRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        Article article0 = this.articleRepository.findById(article.getArticleId()).get();

        article0.addLike();
        Article article1 = this.articleRepository.save(article0);
        assertThat(article1.getLikeCount()).isEqualTo(1);

        Article article2 = this.articleRepository.save(article1);
        article2.subtractLike();
        Article article3 = this.articleRepository.save(article2);
        assertThat(article3.getLikeCount()).isEqualTo(0);

        article3.subtractLike();
        Article article4 = this.articleRepository.save(article3);
        assertThat(article4.getLikeCount()).isEqualTo(0);
    }
}