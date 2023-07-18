package com.skye8.elroykanye.hyrrebus.business.service;

import com.skye8.elroykanye.hyrrebus.api.request.AgencyRequest;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgencyService {
    String addAgency(AgencyRequest newAgency);

    List<Agency> getAllAgencies();

    ResponseEntity<?> getAgencyByName(String agencyName);

    boolean updateAgency(AgencyRequest updatedAgency);

    void deleteAllAgencies();

    void deleteAgencyByName(String agencyName);
}
