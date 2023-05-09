package com.hd.junction.patient.model;

import com.hd.junction.hospital.enumeration.HospitalEnum;
import com.hd.junction.patient.enumeration.PatientSexCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * packageName: com.jd.junction.patient.model
 * fileName: Patient
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@Getter
public class PatientVO {
    @ApiModelProperty(value="병원ID")
    private HospitalEnum hospital_id;
    @ApiModelProperty(value="환자명")
    private String name;
    @ApiModelProperty(value="성별코드")
    private PatientSexCode sex_code;
    @ApiModelProperty(value="생년월일")
    private String birth;
    @ApiModelProperty(value="휴대폰번호")
    private String phone;
}
