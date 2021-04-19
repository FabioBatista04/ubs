package com.bionexo.contract.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UbsContractResponse {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private GeoCodeContractResponse geoCode;
    private ScoresContractResponse scores;

}
