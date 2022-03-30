package com.hit.getcity.model.mapper;

import com.github.slugify.Slugify;
import com.hit.getcity.entity.District;
import com.hit.getcity.entity.Province;
import com.hit.getcity.model.dto.DistrictDTO;
import com.hit.getcity.model.dto.ProvinceDTO;

import org.springframework.beans.factory.annotation.Autowired;

public class Mapper {
    @Autowired
    private static Slugify slugify;

    public static DistrictDTO toDto(District district) {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistrictId(district.getDistrictId());
        districtDTO.setName(district.getName());
        districtDTO.setType(district.getType());
        districtDTO.setSlug(district.getSlug());
        districtDTO.setCode(district.getCode());


        return districtDTO;
    }

    public static ProvinceDTO toDto(Province province) {
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setProvinceId(province.getProvinceId());
        provinceDTO.setName(province.getName());
        provinceDTO.setType(province.getType());

        return provinceDTO;
    }

    public static District toDistrict(DistrictDTO districtDTO, Province province) {
        District district = new District();
        district.setDistrictId(districtDTO.getDistrictId());
        district.setName(districtDTO.getName());
        district.setType(districtDTO.getType());
        district.setSlug(slugify.slugify(districtDTO.getName()));
        if(districtDTO.getType().compareTo("quan")==0) {
            district.setName_with_type("Quận "+districtDTO.getName());
        }else if (districtDTO.getType().compareTo("huyen")==0){
            district.setName_with_type("Huyện "+districtDTO.getName());
        }else {
            district.setName_with_type("Thành Phố "+districtDTO.getName());
        }
        district.setCode(districtDTO.getCode());
        district.setPath(districtDTO.getName() + ", " + province.getName());
        district.setPath_with_type(district.getName_with_type() + ", " + province.getName_with_type());
        district.setProvince(province);

        return district;
    }

    public static Province toProvince(ProvinceDTO provinceDTO) {
        Province province = new Province();
        province.setName(provinceDTO.getName());
        province.setSlug(slugify.slugify(provinceDTO.getName()));
        province.setType(provinceDTO.getType());
        province.setName_with_type(provinceDTO.getType().compareTo("tinh")==0 ? "Tỉnh "
                + provinceDTO.getName() : "Thành Phố " + provinceDTO.getName());
        province.setCode(provinceDTO.getCode());

        return province;
    }
}
