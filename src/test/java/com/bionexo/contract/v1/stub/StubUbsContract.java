package com.bionexo.contract.v1.stub;


import com.bionexo.contract.model.GeoCodeContractResponse;
import com.bionexo.contract.model.PageableResponse;
import com.bionexo.contract.model.ScoresContractResponse;
import com.bionexo.contract.model.UbsContractResponse;
import com.bionexo.ubs.impl.repository.model.GeoCode;
import com.bionexo.ubs.impl.repository.model.Scores;
import com.bionexo.ubs.impl.repository.model.Ubs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class StubUbsContract {
    public static PageableResponse<UbsContractResponse> pageableUbsContractStub() {
        return PageableResponse.<UbsContractResponse>builder()
                .current_page(1)
                .per_page(1)
                .total_entries(37690L)
                .entries(List.of(stubUbsContract()))
                .build();
    }

    private static UbsContractResponse stubUbsContract() {
        return UbsContractResponse.builder()
                .id(5693L)
                .name("USF PAU AMARELO")
                .address("RUA CAVALHEIROS")
                .city("Paulista")
                .phone("8134360978")
                .geoCode(GeoCodeContractResponse.builder()
                        .lat(-7.91984438896156)
                        .lng(-34.8264026641836)
                        .build())
                .scores(ScoresContractResponse.builder()
                        .size(2)
                        .adaptation_for_seniors(1)
                        .medical_equipment(1)
                        .medicine(3)
                        .build())
                .build();
    }

    private static Ubs stubUbs() {
        return Ubs.builder()
                .id(5693L)
                .name("USF PAU AMARELO")
                .address("RUA CAVALHEIROS")
                .city("Paulista")
                .phone("8134360978")
                .geoCode(GeoCode.builder()
                        .lat(-7.91984438896156)
                        .lng(-34.8264026641836)
                        .build())
                .scores(Scores.builder()
                        .size(2)
                        .adaptation_for_seniors(1)
                        .medical_equipment(1)
                        .medicine(3)
                        .build())
                .build();
    }

    public static GeoCode stubGeoCodeRequest() {
        return GeoCode.builder()
                .lat(-10.0)
                .lng(-10.0)
                .build();
    }

    public static Pageable StubPageableRequest() {
        return PageRequest.of(1, 1);
    }

    public static Page<Ubs> stubPageUbsResponse() {
        return new PageImpl<Ubs>(List.of(stubUbs()), PageRequest.of(1, 1), 37690L);
    }
}
