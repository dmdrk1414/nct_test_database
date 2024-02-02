package org.example.repository;

import org.example.entity.AttendanceCheckTime;
import org.example.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceCheckTimeRepository extends JpaRepository<AttendanceCheckTime, Long> {

}
