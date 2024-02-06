package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.TEAM_ARTICLE_CHECK;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "team_article")
public class TeamArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_article_id")
    private Long teamArticleId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "team_article_check", length = 15)
    private TEAM_ARTICLE_CHECK check;

    @Temporal(TemporalType.DATE)
    @Column(name = "team_article_date", nullable = false)
    private LocalDate TeamArticleDate;

    @Builder
    public TeamArticle(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.TeamArticleDate = zonedDateTime.toLocalDate();

        this.check = TEAM_ARTICLE_CHECK.UNCONFIRMED;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateCheck(TEAM_ARTICLE_CHECK check) {
        this.check = check;
    }
}
