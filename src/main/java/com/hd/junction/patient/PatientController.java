package com.hd.junction.patient;

import com.hd.junction.patient.model.PatientListResponseVO;
import com.hd.junction.patient.service.PatientService;
import com.hd.junction.patient.model.PatientDTO;
import com.hd.junction.patient.model.PatientResponseVO;
import com.hd.junction.patient.model.PatientVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * packageName: com.jd.junction.patient
 * fileName: PatientController
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
@RestController
@RequestMapping(path = "patient")
public class PatientController {

    @Resource
    private PatientService patientService;

    @PostMapping(value="regist", name="환자등록")
    @ResponseBody
    public PatientResponseVO regist(@RequestBody PatientVO patientVO) {
        try{
            return patientService.registerPatient(PatientDTO.builder()
                    .birth(patientVO.getBirth())
                    .hospitalId(patientVO.getHospital_id().id)
                    .id(System.currentTimeMillis())
                    .name(patientVO.getName())
                    .phone(patientVO.getPhone())
                    .sexCode(patientVO.getSex_code().code)
                    .build());
        }catch (Exception e){
            return PatientResponseVO.builder().message("fail").patient(new PatientDTO()).build();
        }

    }

    @GetMapping(value="inquiry", name="환자목록조회")
    @ResponseBody
    public PatientListResponseVO regist(@RequestParam Integer pageSize, @RequestParam Integer pageNo) {
        return patientService.inquiryPatient(pageSize,pageNo);
    }
}
