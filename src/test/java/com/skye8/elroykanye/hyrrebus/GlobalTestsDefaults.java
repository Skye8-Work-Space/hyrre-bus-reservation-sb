package com.skye8.elroykanye.hyrrebus;

import com.skye8.elroykanye.hyrrebus.api.dto.*;
import com.skye8.elroykanye.hyrrebus.data.entity.*;
import com.skye8.elroykanye.hyrrebus.data.entity.enums.BusType;

import java.sql.Date;
import java.time.Instant;

public class GlobalTestsDefaults {
    public static final Agency DEFAULT_AGENCY = Agency.builder()
            .agencyId(1L).agencyName("My Agency")
            .build();

    public static final AgencyAddress DEFAULT_AGENCY_ADDRESS = AgencyAddress.builder()
            .street("Mile 25").town("Bamenda").region("NW").build();

    public static final AgencyDto DEFAULT_AGENCY_DTO = AgencyDto.builder()
            .agencyId(1L).agencyName("Some Agency").agencyAddressDto(AgencyAddressDto.builder()
                    .street("Some Street").town("Some Town").region("Some Region")
                    .build())
            .build() ;

    public static final AgencyUser DEFAULT_AGENCY_USER = AgencyUser.builder()
            .agencyUserId(1L).username("user").password("password").firstName("First").lastName("Last")
            .phoneNumber("1234567890")
            .build();

    public static final AgencyUserDto DEFAULT_AGENCY_USER_DTO = AgencyUserDto.builder()
            .agencyUserId(1L).username("userdto").firstName("FirstDto").lastName("LastDto").phoneNumber("1234567890")
            .build();

    public static final Bus DEFAULT_BUS = Bus.builder()
            .busId(1L).busCapacity(70).numberOfRows(14).numberOfColumns(5).busType(BusType.STANDARD)
            .plateNumber("ABC123").busName("My Bus").busNumber(123L)
            .build();

    public static final BusDto DEFAULT_BUS_DTO = BusDto.builder()
            .busId(1L).busCapacity(70).numberOfRows(14).numberOfColumns(5).busType("standard")
            .plateNumber("ABC123DTO").busName("My BusDto").busNumber(123L)
            .build();

    public static final BusSeat DEFAULT_BUS_SEAT = BusSeat.builder()
            .seatId(1L).seatLabel("A1").rowNumber(1).columnNumber(1).build();

    public static final BusSeatDto DEFAULT_BUS_SEAT_DTO = BusSeatDto.builder()
            .seatId(1L).seatLabel("B1").rowNumber(2).columnNumber(1).build();

    public static final TravelSchedule DEFAULT_TRAVEL_SCHEDULE = TravelSchedule.builder()
            .scheduleId(1L)
            .departureDate(Instant.parse("2022-01-03T12:00:00Z"))
            .totalFare(1000L)
            .build();
}
