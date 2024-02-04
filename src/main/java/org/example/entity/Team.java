package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "group_name", length = 30, nullable = false)
    private String groupName;

    @Builder
    public Team(String group) {
        this.groupName = group;
    }

    public void updateGroup(String group) {
        this.groupName = group;
    }
}
