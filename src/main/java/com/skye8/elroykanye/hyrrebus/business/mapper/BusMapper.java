package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.api.dto.BusDto;
import com.skye8.elroykanye.hyrrebus.data.entity.Bus;
import com.skye8.elroykanye.hyrrebus.data.entity.enums.BusType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Elroy Kanye
 * created on: 06-11-21
 * Modified by godsakani
 * modified on: 11-11-2021
 */


@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface BusMapper {
    @Mapping(target = "agencyId", expression = "java(mapBusToDtoAgentId(bus))")
    BusDto mapBusToDto(Bus bus);

    default Long mapBusToDtoAgentId(Bus bus) {
        return bus.getAgency().getAgencyId();
    }

    @InheritInverseConfiguration
    @Mapping(target = "busType", expression = "java(mapDtoToBusTypeBusType(busDto))")
    @Mapping(target = "agency", ignore = true)
    Bus mapDtoToBus(BusDto busDto);

    default BusType mapDtoToBusTypeBusType(BusDto busDto) {
        for(BusType busType : BusType.values()) {
            if(busType.getTypeName().equalsIgnoreCase(busDto.getBusType())) {
                return busType;
            }
        }
        return null;
    }
}
