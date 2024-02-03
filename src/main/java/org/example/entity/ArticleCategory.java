package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.ARTICLE_CATEGORY;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "article_category")
public class ArticleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_category_id")
    private Long articleCategoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "article_category", length = 15, nullable = false)
    private ARTICLE_CATEGORY articleCategory;

    @Builder
    public ArticleCategory(ARTICLE_CATEGORY articleCategory) {
        this.articleCategory = articleCategory;
    }

    public void updateArticleCategory(ARTICLE_CATEGORY articleCategory) {
        this.articleCategory = articleCategory;
    }
}
