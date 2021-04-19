package com.bionexo.ubs.impl;

import com.bionexo.ubs.impl.dto.UbsDTO;
import com.bionexo.ubs.impl.mapper.UbsMapper;
import com.bionexo.ubs.impl.repository.model.Ubs;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class UbsProcessor implements ItemProcessor<UbsDTO, Ubs> {
    @Override
    public Ubs process(UbsDTO dto) {
        return UbsMapper.mapToUbs(dto);
    }
}
