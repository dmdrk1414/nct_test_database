package org.example.repository;

import org.example.entity.AttendanceCheckTime;
import org.example.entity.MemberAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAdminRepository extends JpaRepository<MemberAdmin, Long> {

}
