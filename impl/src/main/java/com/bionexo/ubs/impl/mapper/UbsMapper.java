package com.bionexo.ubs.impl.mapper;


import com.bionexo.ubs.impl.dto.UbsDTO;
import com.bionexo.ubs.impl.enums.Performance;
import com.bionexo.ubs.impl.repository.model.GeoCode;
import com.bionexo.ubs.impl.repository.model.Scores;
import com.bionexo.ubs.impl.repository.model.Ubs;
import com.bionexo.ubs.impl.validation.Validation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UbsMapper {

    public static Ubs mapToUbs(UbsDTO ubsDTO) {
        return Optional.ofNullable(ubsDTO)
                .map(dto -> Ubs.builder()
                        .id(System.nanoTime())
                        .name(ubsDTO.getNom_estab())
                        .address(ubsDTO.getDsc_endereco())
                        .city(ubsDTO.getDsc_cidade())
                        .phone(ubsDTO.getDsc_telefone())
                        .geoCode(mapToGeoCOde(ubsDTO))
                        .scores(mapToScores(ubsDTO))
                        .build())
                .orElse(null);
    }

    private static Scores mapToScores(UbsDTO ubsDTO) {
        return Optional.ofNullable(ubsDTO)
                .map(dto -> Scores.builder()
                        .size(mapToInteger(Validation.validPerformanceEnum(ubsDTO.getDsc_estrut_fisic_ambiencia())))
                        .adaptation_for_seniors(mapToInteger(Validation.validPerformanceEnum(ubsDTO.getDsc_adap_defic_fisic_idosos())))
                        .medical_equipment(mapToInteger(Validation.validPerformanceEnum(ubsDTO.getDsc_equipamentos())))
                        .medicine(mapToInteger(Validation.validPerformanceEnum(ubsDTO.getDsc_medicamentos())))
                        .build())
                .orElse(null);
    }

    private static GeoCode mapToGeoCOde(UbsDTO ubsDTO) {
        return Optional.ofNullable(ubsDTO)
                .map(dto -> GeoCode.builder()
                        .lat(Double.parseDouble(ubsDTO.getVlr_latitude()))
                        .lng(Double.parseDouble(ubsDTO.getVlr_longitude()))
                        .build())
                .orElse(null);
    }

    private static Integer mapToInteger(Performance performance) {
        return Optional.ofNullable(performance)
                .map(Performance::getValue)
                .orElse(null);
    }
}
