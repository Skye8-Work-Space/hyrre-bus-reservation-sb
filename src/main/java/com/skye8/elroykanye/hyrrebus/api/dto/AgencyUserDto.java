package com.skye8.elroykanye.hyrrebus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author  Elroy Kanye
 * created on: 06-11-21
 *
 * modified by Tanju Brunostar
 * modified on: 11-11-21
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgencyUserDto {
    @JsonProperty("user_id")
    private Long agencyUserId;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("user_email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    // from relationship
    @JsonProperty("agency_id")
    private Long agencyId;
}
