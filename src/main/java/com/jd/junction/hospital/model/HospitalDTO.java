package com.jd.junction.hospital.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: com.jd.junction.hospital.model
 * fileName: HospitalDTO
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
@Table(name = "HOSPITAL")
@Entity
@NoArgsConstructor
public class HospitalDTO {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Builder
    public HospitalDTO(Long id, String name, String code, String doctorName){
        this.id = id;
        this.name = name;
        this.code = code;
        this.doctorName = doctorName;
    }
}