package com.skye8.elroykanye.hyrrebus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import com.skye8.elroykanye.hyrrebus.data.entity.enums.BusType;
import lombok.*;

/**
 * @author Elroy Kanye
 * created on: 06-11-21
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    @JsonProperty("bus_id")
    private Long busId;

    @JsonProperty("bus_name")
    private String busName;

    @JsonProperty("plate_number")
    private String plateNumber;

    @JsonProperty("bus_number")
    private Long busNumber;

    @JsonProperty("bus_capacity")
    private Integer busCapacity;

    @JsonProperty("number_of_rows")
    private Integer numberOfRows;

    @JsonProperty("number_of_columns")
    private Integer numberOfColumns;

    @JsonProperty("bus_type")
    private String busType;

    // from relationships
    @JsonProperty("agency_id")
    private Long agencyId;

}
