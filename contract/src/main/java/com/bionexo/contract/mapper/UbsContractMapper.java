package com.bionexo.contract.mapper;

import com.bionexo.contract.model.GeoCodeContractResponse;
import com.bionexo.contract.model.PageableResponse;
import com.bionexo.contract.model.ScoresContractResponse;
import com.bionexo.contract.model.UbsContractResponse;
import com.bionexo.ubs.impl.repository.model.GeoCode;
import com.bionexo.ubs.impl.repository.model.Scores;
import com.bionexo.ubs.impl.repository.model.Ubs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UbsContractMapper {

    public static UbsContractResponse map(Ubs ubs) {
        return Optional.ofNullable(ubs)
                .map(ubsResponse -> UbsContractResponse.builder()
                        .id(ubsResponse.getId())
                        .name(ubsResponse.getName())
                        .address(ubsResponse.getAddress())
                        .phone(ubsResponse.getPhone())
                        .city(ubsResponse.getCity())
                        .geoCode(mapToGeoCodeContractResponse(ubsResponse.getGeoCode()))
                        .scores(mapToScoresContractResponse(ubsResponse.getScores()))
                        .build())
                .orElse(null);
    }

    private static ScoresContractResponse mapToScoresContractResponse(Scores scores) {
        return Optional.ofNullable(scores)
                .map(score -> ScoresContractResponse.builder()
                        .size(score.getSize())
                        .adaptation_for_seniors(score.getAdaptation_for_seniors())
                        .medical_equipment(score.getMedical_equipment())
                        .medicine(score.getMedicine())
                        .build())
                .orElse(null);
    }

    private static GeoCodeContractResponse mapToGeoCodeContractResponse(GeoCode geoCode) {
        return Optional.ofNullable(geoCode)
                .map(geoC -> GeoCodeContractResponse.builder()
                        .lng(geoC.getLng())
                        .lat(geoC.getLat())
                        .build())
                .orElse(null);
    }

    public static PageableResponse<UbsContractResponse> mapToPageableResponse(Page<UbsContractResponse> ubsPage) {
        return Optional.ofNullable(ubsPage)
                .map(ubs -> PageableResponse.<UbsContractResponse>builder()
                        .current_page(ubsPage.getNumber())
                        .per_page(ubsPage.getSize())
                        .total_entries(ubsPage.getTotalElements())
                        .entries(ubsPage.getContent())
                        .build())
                .orElse(null);
    }
}
