package com.hit.getcity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDTO {
    private Long provinceId;
    
    private String name;

    // private String slug;

    private String type;

    // private String name_with_type;

    private Long code;
}
