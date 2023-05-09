package com.jd.junction.patient.service;

import com.jd.junction.hospital.enumeration.HospitalEnum;
import com.jd.junction.hospital.model.HospitalDTO;
import com.jd.junction.patient.model.PatientDTO;
import com.jd.junction.patient.model.PatientResponseVO;
import com.jd.junction.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;

/**
 * packageName: com.jd.junction.patient.service
 * fileName: PatientService
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@Service
public class PatientService {
    @Resource
    private PatientRepository patientRepository;

    /**
     * 환자 등록
     * @param dto
     * @return
     */
    public PatientResponseVO registerPatient(PatientDTO dto){
        Random random = new Random();
        dto.setPatientCode(String.format("%s",Math.abs(random.nextInt())));
        patientRepository.save(dto);
        PatientDTO obj = patientRepository.saveAndFlush(dto);
        return PatientResponseVO.builder().patient(obj).message("success").build();
    }


    
}
