package com.hd.junction.patient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName: com.jd.junction.patient.model
 * fileName: PatientResponseVO
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@NoArgsConstructor
@Getter
public class PatientResponseVO {
    private String message;
    private PatientDTO patient;

    @Builder
    public PatientResponseVO(String message, PatientDTO patient){
        this.message = message;
        this.patient = patient;
    }
}
