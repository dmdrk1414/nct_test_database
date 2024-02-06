package org.example.repository;

import org.example.entity.TeamArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamArticleCommentRepository extends JpaRepository<TeamArticleComment, Long> {

}
