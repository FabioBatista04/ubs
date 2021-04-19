package com.bionexo.ubs.impl.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UbsDTO {
    private String vlr_latitude;
    private String vlr_longitude;
    private String cod_munic;
    private String cod_cnes;
    private String nom_estab;
    private String dsc_endereco;
    private String dsc_bairro;
    private String dsc_cidade;
    private String dsc_telefone;
    private String dsc_estrut_fisic_ambiencia;
    private String dsc_adap_defic_fisic_idosos;
    private String dsc_equipamentos;
    private String dsc_medicamentos;

}
