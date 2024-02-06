package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.TEAM_ARTICLE_CLASSIFICATION;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "team_article_classification")
public class TeamArticleClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_article_classification_id")
    private Long teamArticleClassificationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification", length = 15, nullable = false)
    private TEAM_ARTICLE_CLASSIFICATION classification;

    @Builder
    public TeamArticleClassification(TEAM_ARTICLE_CLASSIFICATION classification) {
        this.classification = classification;
    }

    public void updateClassification(TEAM_ARTICLE_CLASSIFICATION classification) {
        this.classification = classification;
    }
}
