package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.GlobalTestsDefaults;
import com.skye8.elroykanye.hyrrebus.api.dto.AgencyUserDto;
import com.skye8.elroykanye.hyrrebus.data.entity.AgencyUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AgencyUserMapperTest {
    private final AgencyUserMapper agencyUserMapper;

    private AgencyUser agencyUser;
    private AgencyUserDto agencyUserDto;

    @Autowired
    public AgencyUserMapperTest(AgencyUserMapper agencyUserMapper) {
        this.agencyUserMapper = agencyUserMapper;
    }

    @BeforeEach
    void setUp() {
        agencyUser = GlobalTestsDefaults.DEFAULT_AGENCY_USER;
        agencyUser.setAgency(GlobalTestsDefaults.DEFAULT_AGENCY);
        agencyUserDto = GlobalTestsDefaults.DEFAULT_AGENCY_USER_DTO;
    }

    @Test
    void mapAgencyUserToDto() {
        AgencyUserDto agencyUserDto = agencyUserMapper.mapAgencyUserToDto(agencyUser);
        assertEquals(agencyUser.getAgencyUserId(), agencyUserDto.getAgencyUserId());
        assertEquals(agencyUser.getUsername(), agencyUserDto.getUsername());
        assertEquals(agencyUser.getEmail(), agencyUserDto.getEmail());
        assertEquals(agencyUser.getFirstName(), agencyUserDto.getFirstName());
        assertEquals(agencyUser.getLastName(), agencyUserDto.getLastName());
        assertEquals(agencyUser.getPhoneNumber(), agencyUserDto.getPhoneNumber());
        assertEquals(agencyUser.getAgency().getAgencyId(), agencyUserDto.getAgencyId());
    }

    @Test
    void mapDtoToAgencyUser() {
        AgencyUser agencyUser = agencyUserMapper.mapDtoToAgencyUser(agencyUserDto);
        assertEquals(agencyUserDto.getAgencyUserId(), agencyUser.getAgencyUserId());
        assertEquals(agencyUserDto.getUsername(), agencyUser.getUsername());
        assertEquals(agencyUserDto.getEmail(), agencyUser.getEmail());
        assertEquals(agencyUserDto.getFirstName(), agencyUser.getFirstName());
        assertEquals(agencyUserDto.getLastName(), agencyUser.getLastName());
        assertEquals(agencyUserDto.getPhoneNumber(), agencyUser.getPhoneNumber());
    }
}
