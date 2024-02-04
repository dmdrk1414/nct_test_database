package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.SUGGESTION_CHECK;


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

    @Builder
    public Suggestion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
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
