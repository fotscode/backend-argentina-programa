package com.fots.backendap.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] companyImg;
    private String title;
    private String period;
    private String description;
}
