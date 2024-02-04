package org.example.repository;

import org.example.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@AutoConfigureMockMvc
class TeamRepositoryTest {
    private final TeamRepository teamRepository;

    @Autowired
    TeamRepositoryTest(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @BeforeEach
    void setUp() {
        this.teamRepository.deleteAll();
    }

    @Test
    void Team_저장_테스트() {
        String teamName = "누리고시원";
        Team team = this.teamRepository.save(
                Team.builder()
                        .group(teamName)
                        .build()
        );

        assertThat(team.getGroupName()).isEqualTo(teamName);
    }
}