package com.hit.getcity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    private Long districtId;
    
    private String name;

    private String type;

    // private String name_with_type;

    private String slug;
 
    // private String path;

    // private String path_with_type;

    private Long code;

    private Long parent_code;
}
