package com.skye8.elroykanye.hyrrebus.api.dto;

import lombok.*;

import java.time.Instant;

/**
 * @author  Elroy Kanye
 * created on: 06-11-21
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelRouteDto {
    private Long routeId;

    private Long farePerSeat;

    private Instant departureTime;
}
