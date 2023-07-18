package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.GlobalTestsDefaults;
import com.skye8.elroykanye.hyrrebus.api.dto.AgencyAddressDto;
import com.skye8.elroykanye.hyrrebus.api.dto.AgencyDto;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import com.skye8.elroykanye.hyrrebus.data.entity.AgencyAddress;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AgencyMapperTest {
    private final AgencyMapper agencyMapper;

    @Autowired
    public AgencyMapperTest(AgencyMapper agencyMapper) {
        this.agencyMapper = agencyMapper;
    }

    Agency agency = new Agency();
    AgencyAddress agencyAddress = new AgencyAddress();
    AgencyDto agencyDto = new AgencyDto();

    @BeforeEach
    public void setUp() {
        agencyAddress = GlobalTestsDefaults.DEFAULT_AGENCY_ADDRESS;
        agency = GlobalTestsDefaults.DEFAULT_AGENCY;
        agency.setAgencyAddress(agencyAddress);
        agencyAddress.setAgency(agency);

        agencyDto = GlobalTestsDefaults.DEFAULT_AGENCY_DTO;

    }

    @Test
    void mapAgencyToDto() {
        AgencyDto agencyDto = agencyMapper.mapAgencyToDto(agency);
        assertEquals(agency.getAgencyName(), agencyDto.getAgencyName());
        assertEquals(agency.getAgencyId(), agencyDto.getAgencyId());
        assertEquals(agency.getAgencyAddress().getStreet(), agencyDto.getAgencyAddressDto().getStreet());
        assertEquals(agency.getAgencyAddress().getTown(), agencyDto.getAgencyAddressDto().getTown());
        assertEquals(agency.getAgencyAddress().getRegion(), agencyDto.getAgencyAddressDto().getRegion());
    }

    @Test
    void mapDtoToAgency() {
        Agency agency = agencyMapper.mapDtoToAgency(agencyDto);
        assertEquals(agencyDto.getAgencyName(), agency.getAgencyName());
        assertEquals(agencyDto.getAgencyId(), agency.getAgencyId());
        assertEquals(agencyDto.getAgencyAddressDto().getStreet(), agency.getAgencyAddress().getStreet());
        assertEquals(agencyDto.getAgencyAddressDto().getTown(), agency.getAgencyAddress().getTown());
        assertEquals(agencyDto.getAgencyAddressDto().getRegion(), agency.getAgencyAddress().getRegion());


    }
}
