package org.example.repository;

import org.example.entity.Article;
import org.example.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
