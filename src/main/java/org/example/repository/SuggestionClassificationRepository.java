package org.example.repository;

import org.example.entity.ArticleCategory;
import org.example.entity.SuggestionClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionClassificationRepository extends JpaRepository<SuggestionClassification, Long> {

}
