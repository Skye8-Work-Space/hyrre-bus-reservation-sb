package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.GlobalTestsDefaults;
import com.skye8.elroykanye.hyrrebus.api.dto.BusSeatDto;
import com.skye8.elroykanye.hyrrebus.data.entity.BusSeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BusSeatMapperTest {
    private final BusSeatMapper busSeatMapper;

    private BusSeat busSeat;
    private BusSeatDto busSeatDto;

    @Autowired
    public BusSeatMapperTest(BusSeatMapper busSeatMapper) {
        this.busSeatMapper = busSeatMapper;
    }

    @BeforeEach
    void setUp() {
        busSeat = GlobalTestsDefaults.DEFAULT_BUS_SEAT;
        busSeatDto = GlobalTestsDefaults.DEFAULT_BUS_SEAT_DTO;

        busSeat.setBus(GlobalTestsDefaults.DEFAULT_BUS);
        busSeat.setTravelSchedule(GlobalTestsDefaults.DEFAULT_TRAVEL_SCHEDULE);
    }

    @Test
    void mapBusSeatToDto() {
        BusSeatDto busSeatDto = busSeatMapper.mapBusSeatToDto(busSeat);
        assertEquals(busSeatDto.getSeatId(), busSeat.getSeatId());
        assertEquals(busSeatDto.getSeatLabel(), busSeat.getSeatLabel());
        assertEquals(busSeatDto.getRowNumber(), busSeat.getRowNumber());
        assertEquals(busSeatDto.getColumnNumber(), busSeat.getColumnNumber());
        assertEquals(busSeatDto.getBusId(), busSeat.getBus().getBusId());
        // TODO add tests for schedule too
    }

    @Test
    void mapDtoToBusSeat() {
    }
}
