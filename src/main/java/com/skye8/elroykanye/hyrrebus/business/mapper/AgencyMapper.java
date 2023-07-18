package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.api.dto.AgencyAddressDto;
import com.skye8.elroykanye.hyrrebus.api.dto.AgencyDto;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import com.skye8.elroykanye.hyrrebus.data.entity.AgencyAddress;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Tanju Brunostar
 * created on 06/11/21
 *
 * Modified by: Elroy Kanye
 * Modified on: 11/11/21
 */
@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface AgencyMapper {

    @Mapping(target = "agencyAddressDto", expression = "java(mapAgencyAddressToDto(agency.getAgencyAddress()))")
    AgencyDto mapAgencyToDto(Agency agency);

    default AgencyAddressDto mapAgencyAddressToDto(AgencyAddress agencyAddress) {
        return new AgencyAddressDto(agencyAddress.getStreet(), agencyAddress.getTown(), agencyAddress.getRegion());
    }

    @InheritInverseConfiguration
    @Mapping(target = "buses", ignore = true)
    @Mapping(target = "busStopPoints", ignore = true)
    @Mapping(target = "agencyUser", ignore = true)
    @Mapping(target = "agencyAddress", expression = "java(mapAgencyAddressDtoToEntity(agencyDto.getAgencyAddressDto()))")
    Agency mapDtoToAgency(AgencyDto agencyDto);

    default AgencyAddress mapAgencyAddressDtoToEntity(AgencyAddressDto agencyAddressDto) {
        return AgencyAddress.builder()
                .street(agencyAddressDto.getStreet())
                .town(agencyAddressDto.getTown())
                .region(agencyAddressDto.getRegion())
                .build();
    }
}
