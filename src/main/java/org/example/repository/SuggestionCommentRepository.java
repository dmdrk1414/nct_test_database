package org.example.repository;

import org.example.entity.SuggestionComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionCommentRepository extends JpaRepository<SuggestionComment, Long> {

}
