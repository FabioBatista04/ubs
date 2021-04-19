package com.bionexo.contract.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageableResponse<T> {
    private Integer current_page;
    private Integer per_page;
    private Long total_entries;
    @Builder.Default
    private List<T> entries = new ArrayList<>();

}
