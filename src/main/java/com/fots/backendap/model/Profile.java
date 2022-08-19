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
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] bannerImg;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profileImg;
    private String name;
    private String title;
    private String description;
}
