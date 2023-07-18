package com.skye8.elroykanye.hyrrebus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgencyAddressDto {
    @JsonProperty("street")
    private String street;

    @JsonProperty("town")
    private String town;

    @JsonProperty("region")
    private String region;
}
