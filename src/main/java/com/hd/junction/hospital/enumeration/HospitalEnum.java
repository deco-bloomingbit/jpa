package com.hd.junction.hospital.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName: com.jd.junction.hospital.enumeration
 * fileName: HospitalEnum
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
public enum HospitalEnum {
    MANMAN(1111L, "맨남성")
    , SIAN(2222L, "시안의원")
    , MOZERIM(3333L, "모제림")
    , MEHI(4444L, "미하이")
    ;

    public final Long id;
    public final String description;

    private HospitalEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    private static final Map<Long, HospitalEnum> typesByValue = new HashMap<>(HospitalEnum.values().length);

    static {
        for (HospitalEnum type : HospitalEnum.values()) {
            typesByValue.put(type.id, type);
        }
    }
}
