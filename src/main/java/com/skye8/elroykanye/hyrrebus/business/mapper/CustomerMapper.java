package com.skye8.elroykanye.hyrrebus.business.mapper;

import com.skye8.elroykanye.hyrrebus.api.dto.CustomerDto;

import com.skye8.elroykanye.hyrrebus.data.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Nfon Andrew
 * Created On  06-11-21
 */

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl")
public interface CustomerMapper {
    CustomerDto mapCustomerDtoTo (Customer customer);

    @InheritInverseConfiguration
    @Mapping(target = "travelSchedules", ignore = true)
    Customer mapCustomerDtoTo(CustomerDto customerDto);

}
