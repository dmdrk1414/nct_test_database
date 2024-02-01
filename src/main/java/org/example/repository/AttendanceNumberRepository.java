package org.example.repository;

import org.example.entity.AttendanceNumber;
import org.example.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceNumberRepository extends JpaRepository<AttendanceNumber, Long> {

}
