package org.example.repository;

import org.example.entity.AttendanceWeekDate;
import org.example.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceWeekDateRepository extends JpaRepository<AttendanceWeekDate, Long> {

}
