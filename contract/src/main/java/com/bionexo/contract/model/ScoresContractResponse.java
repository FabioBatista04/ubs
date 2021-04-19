package com.bionexo.contract.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoresContractResponse {

    private Integer size;
    private Integer adaptation_for_seniors;
    private Integer medical_equipment;
    private Integer medicine;

}
