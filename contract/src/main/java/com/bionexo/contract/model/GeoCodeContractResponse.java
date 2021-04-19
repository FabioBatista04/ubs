package com.bionexo.contract.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoCodeContractResponse {

    private Double lat;
    @JsonProperty("long")
    private Double lng;
}
