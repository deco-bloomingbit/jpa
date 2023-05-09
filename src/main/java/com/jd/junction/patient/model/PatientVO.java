package com.jd.junction.patient.model;

import com.jd.junction.hospital.enumeration.HospitalEnum;
import com.jd.junction.patient.enumeration.PatientSexCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;

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
