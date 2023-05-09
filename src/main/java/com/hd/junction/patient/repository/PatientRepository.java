package com.hd.junction.patient.repository;

import com.hd.junction.patient.model.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: com.jd.junction.patient
 * fileName: PatientRepository
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientDTO, Long> {
}
