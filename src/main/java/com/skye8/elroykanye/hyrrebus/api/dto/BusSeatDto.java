package com.skye8.elroykanye.hyrrebus.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skye8.elroykanye.hyrrebus.data.entity.Bus;
import com.skye8.elroykanye.hyrrebus.data.entity.TravelSchedule;
import lombok.*;

/**
 * @author Nfon Andrew
 * Created On  06-11-21
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusSeatDto {
    @JsonProperty("seat_id")
    private Long seatId;

    @JsonProperty("seat_label")
    private String seatLabel;

    @JsonProperty("row_number")
    private Integer rowNumber;

    @JsonProperty("column_number")
    private Integer columnNumber;

    // from relationships
    @JsonProperty("bus_id")
    private Long busId;

    @JsonProperty("travel_schedule_id")
    private Long travelScheduleId;
}

