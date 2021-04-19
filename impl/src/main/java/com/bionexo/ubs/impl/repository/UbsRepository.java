package com.bionexo.ubs.impl.repository;


import com.bionexo.ubs.impl.repository.model.GeoCode;
import com.bionexo.ubs.impl.repository.model.Ubs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UbsRepository extends MongoRepository<Ubs, Long> {

    @Query("{ \"geoCode\":{ $nearSphere: ?0 } }")
    Page<Ubs> findByGeoCode(GeoCode geoCode, Pageable valid);
}
