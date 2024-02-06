package org.example.repository;

import org.example.entity.TeamArticleClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamArticleClassificationRepository extends JpaRepository<TeamArticleClassification, Long> {

}
