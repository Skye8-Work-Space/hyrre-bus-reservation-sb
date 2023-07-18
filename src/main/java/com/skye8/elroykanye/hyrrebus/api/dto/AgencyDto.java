package com.skye8.elroykanye.hyrrebus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skye8.elroykanye.hyrrebus.data.entity.AgencyAddress;
import lombok.*;

/**
 * @author Tanju Brunostar
 * created on 06/11/21
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgencyDto {
    @JsonProperty("agency_id")
    private Long agencyId;

    @JsonProperty("agency_name")
    private String agencyName;

    @JsonProperty("agency_address")
    private AgencyAddressDto agencyAddressDto;
}
