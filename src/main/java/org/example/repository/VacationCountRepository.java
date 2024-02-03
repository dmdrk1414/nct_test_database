package org.example.repository;

import org.example.entity.AttendanceCheckTime;
import org.example.entity.VacationCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationCountRepository extends JpaRepository<VacationCount, Long> {

}
