package com.skye8.elroykanye.hyrrebus.business.service.impl;

import com.skye8.elroykanye.hyrrebus.api.request.AgencyRequest;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import com.skye8.elroykanye.hyrrebus.data.entity.AgencyAddress;
import com.skye8.elroykanye.hyrrebus.data.repository.AgencyRepository;
import com.skye8.elroykanye.hyrrebus.business.service.AgencyService;
import com.skye8.elroykanye.hyrrebus.exception.EntityException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Override
    @Transactional
    public String addAgency(AgencyRequest newAgency) {
        AgencyAddress agencyAddress = AgencyAddress.builder().region(newAgency.getRegion())
                .town(newAgency.getTown()).street(newAgency.getStreet())
                .build();
        Agency agency = Agency.builder()
                .agencyName(newAgency.getName())
                .build();

        // set the child ref
        agencyAddress.setAgency(agency);
        // set the parent ref
        agency.setAgencyAddress(agencyAddress);

        if(agencyRepository.existsById(agency.getAgencyId())) {
            throw new EntityException.EntityAlreadyExistsException("agency", agency.getAgencyId());
        }
        agencyRepository.save(agency);
        return "Agency added successfully";
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getAgencyByName(String agencyName) {
        Optional<Agency> agencyOptional =  agencyRepository.findByAgencyName(agencyName);
        if(agencyOptional.isPresent()) {
            return new ResponseEntity<>(agencyOptional.get(), HttpStatus.FOUND);
        } else return new ResponseEntity<>("Agency does not exist", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public boolean updateAgency(AgencyRequest updatedAgency) {
        boolean updated = false;
        Optional<Agency> agencyOptional = agencyRepository.findByAgencyName(updatedAgency.getName());
        try {
            agencyOptional.ifPresent(agency -> {
                AgencyAddress repoAgencyAddress = agency.getAgencyAddress();
                repoAgencyAddress.setStreet(updatedAgency.getStreet());
                repoAgencyAddress.setTown(updatedAgency.getTown());
                repoAgencyAddress.setRegion(updatedAgency.getRegion());

                agency.setAgencyName(updatedAgency.getName());
                agency.setAgencyAddress(repoAgencyAddress);

                agencyRepository.save(agency);
            }); updated = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return updated;
    }

    @Override
    public void deleteAllAgencies() {
        agencyRepository.deleteAll();
    }

    @Override
    public void deleteAgencyByName(String agencyName) {
        agencyRepository.deleteByAgencyName(agencyName);
    }


}
