package com.jd.junction.hospital.repository;

import com.jd.junction.hospital.model.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: com.jd.junction.hospital
 * fileName: HospitalRepository
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
public interface HospitalRepository extends JpaRepository<HospitalDTO, Long> {
}
