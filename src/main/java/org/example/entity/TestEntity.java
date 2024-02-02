package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constant.TEST_ENUM;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "")
@DynamicInsert // insert할시 Null 배제
@DynamicUpdate // update할시 Null 배재
@Builder
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TEST_ENUM testEnum;
}
