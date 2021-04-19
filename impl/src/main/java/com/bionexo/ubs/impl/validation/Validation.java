package com.bionexo.ubs.impl.validation;

import com.bionexo.ubs.impl.enums.Performance;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validation {

    public static Pageable validPageable(Integer page, Integer perPage) {
        int pageValidated = page >= 0 ? page : 0;
        int sizeValidated = perPage > 0 ? perPage : 1;
        return PageRequest.of(pageValidated, sizeValidated);
    }

    public static Performance validPerformanceEnum(String performance) {
        if (performance.equalsIgnoreCase("Desempenho mediano ou  um pouco abaixo da média")) {
            return Performance.DESEMPENHO_MEDIANO_OU_UM_POUCO_ABAIXO;
        } else if (performance.equalsIgnoreCase("Desempenho acima da média")) {
            return Performance.DESEMPENHO_ACIMA;
        } else if (performance.equalsIgnoreCase("Desempenho muito acima da média")) {
            return Performance.DESEMPENHO_MUITO_ACIMA;
        }
        return null;
    }
}
