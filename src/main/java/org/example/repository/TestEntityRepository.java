package org.example.repository;

import org.example.entity.MemberAdmin;
import org.example.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

}
