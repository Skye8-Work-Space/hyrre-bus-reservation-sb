package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.GlobalTestsDefaults;
import com.skye8.elroykanye.hyrrebus.api.dto.BusDto;
import com.skye8.elroykanye.hyrrebus.data.entity.Bus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BusMapperTest {
    private final BusMapper busMapper;

    private Bus bus;
    private BusDto busDto;

    @Autowired
    public BusMapperTest(BusMapper busMapper) {
        this.busMapper = busMapper;
    }

    @BeforeEach
    void setUp() {
        bus = GlobalTestsDefaults.DEFAULT_BUS;
        busDto = GlobalTestsDefaults.DEFAULT_BUS_DTO;

        bus.setAgency(GlobalTestsDefaults.DEFAULT_AGENCY);
    }

    @Test
    void mapBusToDto() {
        BusDto busDto1 = busMapper.mapBusToDto(bus);
        assertNotNull(busDto1);
        assertEquals(bus.getBusId(), busDto1.getBusId());
        assertEquals(bus.getBusName(), busDto1.getBusName());
        assertEquals(bus.getPlateNumber(), busDto1.getPlateNumber());
        assertEquals(bus.getBusNumber(), busDto1.getBusNumber());
        assertEquals(bus.getBusCapacity(), busDto1.getBusCapacity());
        assertEquals(bus.getNumberOfRows(), busDto1.getNumberOfRows());
        assertEquals(bus.getNumberOfColumns(), busDto1.getNumberOfColumns());
        assertEquals(bus.getBusType().name(), busDto1.getBusType());
        assertEquals(bus.getAgency().getAgencyId(), busDto1.getAgencyId());
    }

    @Test
    void mapDtoToBus() {
        Bus bus1 = busMapper.mapDtoToBus(busDto);
        assertNotNull(bus1);
        assertEquals(busDto.getBusId(), bus1.getBusId());
        assertEquals(busDto.getBusName(), bus1.getBusName());
        assertEquals(busDto.getPlateNumber(), bus1.getPlateNumber());
        assertEquals(busDto.getBusNumber(), bus1.getBusNumber());
        assertEquals(busDto.getBusCapacity(), bus1.getBusCapacity());
        assertEquals(busDto.getNumberOfRows(), bus1.getNumberOfRows());
        assertEquals(busDto.getNumberOfColumns(), bus1.getNumberOfColumns());
        assertEquals(busDto.getBusType(), bus1.getBusType().getTypeName());
    }
}
