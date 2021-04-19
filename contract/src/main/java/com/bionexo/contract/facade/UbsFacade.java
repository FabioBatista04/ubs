package com.bionexo.contract.facade;


import com.bionexo.contract.mapper.UbsContractMapper;
import com.bionexo.contract.model.PageableResponse;
import com.bionexo.contract.model.UbsContractResponse;
import com.bionexo.ubs.impl.UbsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UbsFacade {

    private final UbsService service;

    public PageableResponse<UbsContractResponse> getUbs(List<Double> query, Integer page, Integer perPage) {
        return UbsContractMapper.mapToPageableResponse(service.getUbs(query, page, perPage)
                .map(UbsContractMapper::map));
    }
}
