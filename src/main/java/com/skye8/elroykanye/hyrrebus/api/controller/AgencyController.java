package com.skye8.elroykanye.hyrrebus.api.controller;

import com.skye8.elroykanye.hyrrebus.api.request.AgencyRequest;
import com.skye8.elroykanye.hyrrebus.data.entity.Agency;
import com.skye8.elroykanye.hyrrebus.business.service.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/agency")
public class AgencyController {
    private final AgencyService agencyService;

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody AgencyRequest newAgency) {
        return new ResponseEntity(agencyService.addAgency(newAgency), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Agency> getAll() {
        return agencyService.getAllAgencies();
    }

    @GetMapping(value = "{agencyName}")
    public ResponseEntity<?> getAgencyByName(@PathVariable(value = "agencyName") String agencyName) {
        return agencyService.getAgencyByName(agencyName);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateAgency(@RequestBody AgencyRequest updatedAgency) {
        return agencyService.updateAgency(updatedAgency) ?
                new ResponseEntity<>("Update successful", HttpStatus.OK):
                new ResponseEntity<>("Updated failed", HttpStatus.CONFLICT);
    }

    @DeleteMapping(value = "/all")
    public void deleteAll() {
        agencyService.deleteAllAgencies();
    }

    @DeleteMapping(value = "{agencyName}")
    public void deleteAgencyByName(@PathVariable(value = "agencyName") String agencyName) {
        agencyService.deleteAgencyByName(agencyName);

    }
}
