package com.hd.junction.patient.service;

import com.hd.junction.patient.exception.ParameterException;
import com.hd.junction.patient.model.PatientDTO;
import com.hd.junction.patient.model.PatientListResponseVO;
import com.hd.junction.patient.model.PatientResponseVO;
import com.hd.junction.patient.repository.PatientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
@Log4j2
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
        dto.setPatientCode(makePatientCode());
        patientRepository.save(dto);
        PatientDTO obj = patientRepository.saveAndFlush(dto);
        return PatientResponseVO.builder().patient(obj).message("success").build();
    }

    private String makePatientCode(){
        Random random = new Random();
        return String.format("%s",Math.abs(random.nextInt()));
    }


    /**
     * 환자 조회
     * @param pageSize
     * @param pageNo
     * @return
     */
    public PatientListResponseVO inquiryPatient(Integer pageSize, Integer pageNo){
        try{
            if(pageSize == null || pageSize < 0){
                throw new ParameterException();
            }
            if(pageNo == null || pageNo < 0){
                throw new ParameterException();
            }
            Page<PatientDTO> page = patientRepository.findAll(
                    PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, "name")));

            return PatientListResponseVO.builder().list(page.toList()).message("success").build();
        }catch (ParameterException e){
            return PatientListResponseVO.builder().list(new ArrayList<>())
                    .message(String.format("파라미터를 확인해주세요. pageSize: %s, pageNo: %s", pageSize, pageNo)).build();
        }catch (Exception e){
            return PatientListResponseVO.builder().list(new ArrayList<>())
                    .message(e.getMessage()).build();
        }

    }

}
