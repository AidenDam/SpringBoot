package com.hit.getcity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    @Nationalized
    private String name;

    @Nationalized
    private String type;

    @Nationalized
    private String name_with_type;

    @Nationalized
    private String slug;

    @Nationalized 
    private String path;

    @Nationalized
    private String path_with_type;

    private Long code;

    private Long parent_code;

    @ManyToOne
    @JoinColumn(name = "procinces_id")
    private Province province;
}
