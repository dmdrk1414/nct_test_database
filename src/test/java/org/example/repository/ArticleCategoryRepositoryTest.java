package org.example.repository;

import org.example.constant.ARTICLE_CATEGORY;
import org.example.entity.Article;
import org.example.entity.ArticleCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class ArticleCategoryRepositoryTest {
    private final ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    ArticleCategoryRepositoryTest(ArticleCategoryRepository articleCategoryRepository) {
        this.articleCategoryRepository = articleCategoryRepository;
    }

    @BeforeEach
    void setUp() {
        articleCategoryRepository.deleteAll();
    }

    @Test
    void ArticleCategory_저장_테스트() {
        ArticleCategory articleCategory_1 = articleCategoryRepository.save(ArticleCategory.builder()
                .articleCategory(ARTICLE_CATEGORY.FREEDOM)
                .build());

        ArticleCategory articleCategory_2 = articleCategoryRepository.save(ArticleCategory.builder()
                .articleCategory(ARTICLE_CATEGORY.STUDY)
                .build());

        ArticleCategory articleCategory_3 = articleCategoryRepository.save(ArticleCategory.builder()
                .articleCategory(ARTICLE_CATEGORY.INFORMATION)
                .build());

        ArticleCategory target_1 = articleCategoryRepository.findById(articleCategory_1.getArticleCategoryId()).get();
        ArticleCategory target_2 = articleCategoryRepository.findById(articleCategory_2.getArticleCategoryId()).get();
        ArticleCategory target_3 = articleCategoryRepository.findById(articleCategory_3.getArticleCategoryId()).get();

        assertThat(target_1.getArticleCategory()).isEqualTo(ARTICLE_CATEGORY.FREEDOM);
        assertThat(target_2.getArticleCategory()).isEqualTo(ARTICLE_CATEGORY.STUDY);
        assertThat(target_3.getArticleCategory()).isEqualTo(ARTICLE_CATEGORY.INFORMATION);
    }
}