package com.bionexo.ubs.impl;

import com.bionexo.ubs.exception.IllegalParameterException;
import com.bionexo.ubs.impl.repository.UbsRepository;
import com.bionexo.ubs.impl.repository.model.GeoCode;
import com.bionexo.ubs.impl.repository.model.Ubs;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.bionexo.ubs.impl.validation.Validation.validPageable;

@Service
@AllArgsConstructor
public class UbsService {

    private final UbsRepository repository;

    public Page<Ubs> getUbs(List<Double> query, Integer page, Integer perPage) {

        if (query.size() != 2 || CollectionUtils.isEmpty(query))
            throw new IllegalParameterException("Informe latitude e longitude");

        Double lat = query.get(0);
        Double lng = query.get(1);

        if (lat > 90 || lat < -90)
            throw new IllegalParameterException("latitude deve estar entre -90 e 90");

        if (lng > 180 || lng < -180)
            throw new IllegalParameterException("latitude deve estar entre -180 e 180");

        GeoCode geoCode = GeoCode.builder().lat(lat).lng(lng).build();

        return repository.findByGeoCode(geoCode, validPageable(page, perPage));
    }
}
