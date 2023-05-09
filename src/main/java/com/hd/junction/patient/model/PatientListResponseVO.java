package com.hd.junction.patient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packageName: com.jd.junction.patient.model
 * fileName: PatientListResponseVO
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
public class PatientListResponseVO {
    private String message;
    private List<PatientDTO> list;

    @Builder
    public PatientListResponseVO(String message, List<PatientDTO> list){
        this.message = message;
        this.list = list;
    }
}
