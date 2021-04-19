package com.bionexo.ubs.impl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Performance {
    DESEMPENHO_MEDIANO_OU_UM_POUCO_ABAIXO(1),
    DESEMPENHO_ACIMA(2),
    DESEMPENHO_MUITO_ACIMA(3);

    private final Integer value;
}
