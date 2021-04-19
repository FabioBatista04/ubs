package com.bionexo.ubs.impl.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ubs")
public class Ubs {

    @Id
    private Long id;
    private String name;
    private String address;
    private String city;
    private String phone;
    @GeoSpatialIndexed(name = "geoCode", type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoCode geoCode;
    private Scores scores;

}
