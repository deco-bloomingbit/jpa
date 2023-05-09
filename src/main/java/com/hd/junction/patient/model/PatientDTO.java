package com.hd.junction.patient.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: com.jd.junction.patient.model
 * fileName: PatientDTO
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@Data
@Table(name = "PATIENT")
@Entity
@NoArgsConstructor
public class PatientDTO {
    @Id
    private Long id;
    @Column(name = "HOSPITAL_ID")
    private Long hospitalId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PATIENT_CODE")
    private String patientCode;
    @Column(name = "SEX_CODE")
    private String sexCode;
    @Column(name = "BIRTH")
    private String birth;
    @Column(name = "PHONE")
    private String phone;

    @Builder
    public PatientDTO(Long id, Long hospitalId, String name
            , String patientCode, String sexCode, String birth, String phone){
        this.id = id;
        this.hospitalId = hospitalId;
        this.name = name;
        this.patientCode = patientCode;
        this.sexCode = sexCode ;
        this.birth = birth;
        this.phone = phone;

    }

}
