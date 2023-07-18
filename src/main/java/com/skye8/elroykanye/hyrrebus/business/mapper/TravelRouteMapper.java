package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.api.dto.TravelRouteDto;
import com.skye8.elroykanye.hyrrebus.api.dto.TravelTicketDto;
import com.skye8.elroykanye.hyrrebus.data.entity.TravelRoute;
import com.skye8.elroykanye.hyrrebus.data.entity.TravelTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author  Elroy Kanye
 * created on: 06-11-21
 * Modified by: Nfon Andrew
 * modified on: 11-11-21
 */

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface TravelRouteMapper {
    TravelRouteDto mapTravelRouteDtoTo (TravelRoute travelRoute);

    @Mapping(target="bus", ignore = true)
    @Mapping(target="busDropPoint", ignore = true)
    @Mapping(target="busBoardPoint", ignore = true)
    @Mapping(target="travelSchedule", ignore = true)
    TravelRoute mapDtoToTravelRoute (TravelRouteDto travelRouteDto);
}

