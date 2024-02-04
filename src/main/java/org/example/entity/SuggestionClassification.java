package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.constant.SUGGESTION_CLASSIFICATION;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "suggestion_classification")
public class SuggestionClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suggestion_classification_id")
    private Long suggestionClassificationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification", length = 15, nullable = false)
    private SUGGESTION_CLASSIFICATION classification;

    @Builder
    public SuggestionClassification(SUGGESTION_CLASSIFICATION classification) {
        this.classification = classification;
    }

    public void updateClassification(SUGGESTION_CLASSIFICATION classification) {
        this.classification = classification;
    }
}
