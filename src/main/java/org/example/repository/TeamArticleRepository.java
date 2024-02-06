package org.example.repository;

import org.example.entity.TeamArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamArticleRepository extends JpaRepository<TeamArticle, Long> {

}
