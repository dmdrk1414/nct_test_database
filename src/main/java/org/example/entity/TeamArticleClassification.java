package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.TEAM_ARTICLE_CLASSIFICATION;

import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teamArticleClassification")
    private List<TeamArticle> teamArticles;

    @Builder
    public TeamArticleClassification(TEAM_ARTICLE_CLASSIFICATION classification) {
        this.classification = classification;
    }

    public void updateClassification(TEAM_ARTICLE_CLASSIFICATION classification) {
        this.classification = classification;
    }

    public List<TeamArticle> getTeamArticles() {
        return teamArticles;
    }

    public void addTeamArticle(final TeamArticle teamArticle) {
        this.teamArticles.add(teamArticle);
        if (teamArticle.getTeamArticleClassification() != this) { // 무한루프에 빠지지 않도록 체크
            teamArticle.setTeamArticleClassification(this);
        }
    }
}
