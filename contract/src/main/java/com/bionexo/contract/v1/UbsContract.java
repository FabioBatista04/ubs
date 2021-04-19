package com.bionexo.contract.v1;


import com.bionexo.contract.facade.UbsFacade;
import com.bionexo.contract.model.PageableResponse;
import com.bionexo.contract.model.UbsContractResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1")
public class UbsContract {

    private final UbsFacade facade;

    @GetMapping("/find_ubs")
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse<UbsContractResponse> findUbs(@RequestParam List<Double> query,
                                                         @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                         @RequestParam(value = "per_page", required = false, defaultValue = "10") int per_page) {
        return facade.getUbs(query, page, per_page);
    }

}
