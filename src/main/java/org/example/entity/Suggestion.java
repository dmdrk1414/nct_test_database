package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.SUGGESTION_CHECK;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "suggestion")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suggestion_id")
    private Long suggestionId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "suggestion_check", length = 15)
    private SUGGESTION_CHECK check;

    @Temporal(TemporalType.DATE)
    @Column(name = "suggestion_date", nullable = false)
    private LocalDate suggestionDate;

    @Builder
    public Suggestion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
        // https://www.daleseo.com/java8-zoned-date-time/
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));
        this.suggestionDate = zonedDateTime.toLocalDate();

        this.check = SUGGESTION_CHECK.UNCONFIRMED;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateCheck(SUGGESTION_CHECK check) {
        this.check = check;
    }
}
