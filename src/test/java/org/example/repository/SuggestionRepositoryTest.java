package org.example.repository;

import org.example.constant.SUGGESTION_CHECK;
import org.example.entity.Suggestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class SuggestionRepositoryTest {
    private final SuggestionRepository suggestionRepository;

    @Autowired
    SuggestionRepositoryTest(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    @BeforeEach
    void setUp() {
        this.suggestionRepository.deleteAll();
    }

    @Test
    void Suggestion_저장_테스트() {
        String title = "test title";
        String content = "test content";

        Suggestion suggestion = suggestionRepository.save(Suggestion.builder()
                .title(title)
                .content(content)
                .build());

        assertThat(suggestion.getTitle()).isEqualTo(title);
        assertThat(suggestion.getContent()).isEqualTo(content);
        assertThat(suggestion.getCheck()).isEqualTo(SUGGESTION_CHECK.UNCONFIRMED);
    }

    @Test
    void Suggestion_업데이트_테스트() {
        String title = "test title";
        String content = "test content";
        String updateTitle = "update title";
        String updateContent = "update content";

        Suggestion suggestion = suggestionRepository.save(Suggestion.builder()
                .title(title)
                .content(content)
                .build());

        suggestion.updateTitle(updateTitle);
        suggestion.updateContent(updateContent);
        suggestion.updateCheck(SUGGESTION_CHECK.CONFIRMED);
        Suggestion suggestion1 = suggestionRepository.save(suggestion);
        assertThat(suggestion1.getTitle()).isEqualTo(updateTitle);
        assertThat(suggestion1.getContent()).isEqualTo(updateContent);
        assertThat(suggestion1.getCheck()).isEqualTo(SUGGESTION_CHECK.CONFIRMED);
    }
}