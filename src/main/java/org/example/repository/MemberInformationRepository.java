package org.example.repository;

import org.example.entity.MemberInformation;
import org.example.entity.TempMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInformationRepository extends JpaRepository<MemberInformation, Long> {

}
