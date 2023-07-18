package com.skye8.elroykanye.hyrrebus.api.dto;

import lombok.*;

import java.sql.Date;
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
public class TravelScheduleDto {
    private Long scheduleId;

    private Instant departureDate;

    private Long totalFare;
}
