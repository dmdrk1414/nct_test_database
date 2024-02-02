package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) // 추가
@Table(name = "base_entity")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_entity_id")
    private Long baseEntityId;

    @Column(name = "crt_date")
    @CreatedDate
    private LocalDateTime crtDt;

    @LastModifiedDate
    private LocalDateTime updatedDt;

    @Column(name = "crt_timestamp")
    @CreationTimestamp
    private LocalDateTime crt_timestamp;

    @Column(name = "udt_dt")
    @UpdateTimestamp
    private LocalDateTime udtDt;
}
