package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.api.dto.BusSeatDto;
import com.skye8.elroykanye.hyrrebus.data.entity.BusSeat;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Nfon Andrew
 * Created On  06-11-21
 */

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface BusSeatMapper {
    @Mapping(target = "busId", expression = "java(busSeat.getBus().getBusId())")
    @Mapping(target = "travelScheduleId", expression = "java(busSeat.getTravelSchedule().getScheduleId())")
    BusSeatDto mapBusSeatToDto(BusSeat busSeat);

    @InheritInverseConfiguration
    @Mapping(target = "bus", ignore = true)
    @Mapping(target = "travelSchedule", ignore = true)
    BusSeat mapDtoToBusSeat(BusSeatDto busSeatDto);
}
