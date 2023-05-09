package com.jd.junction.patient.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName: com.jd.junction.patient.enumeration
 * fileName: PatientSexCode
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
public enum PatientSexCode {
    MALE("MALE", "남성")
    , FEMALE("FEMALE", "여성")
    , NONE("NONE", "미입력")
    ;

    public final String code;
    public final String description;

    private PatientSexCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private static final Map<String, PatientSexCode> typesByValue = new HashMap<>(com.jd.junction.hospital.enumeration.HospitalEnum.values().length);

    static {
        for (PatientSexCode type : PatientSexCode.values()) {
            typesByValue.put(type.code, type);
        }
    }
}