package com.hd.junction.hospital.service;

import com.hd.junction.hospital.enumeration.HospitalEnum;
import com.hd.junction.hospital.model.HospitalDTO;
import com.hd.junction.hospital.repository.HospitalRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * packageName: com.jd.junction.hospital.service
 * fileName: HospitalService
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
@Log4j2
public class HospitalService {
    @Resource
    private HospitalRepository hospitalRepository;

    /**
     * 병원 입력
     */
    @PostConstruct
    public void putHospital(){
        for(HospitalEnum item : HospitalEnum.values()){
            HospitalDTO hospitalDTO = HospitalDTO.builder()
                    .name(item.description)
                    .code(UUID.randomUUID().toString().substring(0,20))
                    .id(item.id)
                    .doctorName(String.format("%s 병원장님", item.description))
                    .build();
            hospitalRepository.saveAndFlush(hospitalDTO);
        }
    }
}
