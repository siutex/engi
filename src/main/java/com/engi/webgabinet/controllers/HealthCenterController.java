package com.engi.webgabinet.controllers;

import com.engi.webgabinet.domain.HealthCentre;
import com.engi.webgabinet.dto.HealthCenterDTO;
import com.engi.webgabinet.services.HealthCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HealthCenterController {
    final static Logger logger = LoggerFactory.getLogger(HealthCenterController.class);

    @Autowired
    HealthCenterService healthCenterService;



    @GetMapping(value = "/hospital", produces = "application/json")
    public List<HealthCenterDTO> getHealthCenter(ModelMap model) {
        List<HealthCentre> healthCentreList = healthCenterService.findAll();
        List<HealthCenterDTO> healthCenterDTOList = new ArrayList<>();
        for (HealthCentre healthCentre : healthCentreList) {
            HealthCenterDTO healthCenterDTO = new HealthCenterDTO();
            healthCenterDTO.setHealthCenterId(healthCentre.getId());
            healthCenterDTO.setHealthCenterName(healthCentre.getName());
            healthCenterDTO.setAddress(healthCentre.getAddress());
            healthCenterDTO.setCityCode(healthCentre.getCityCode());
            healthCenterDTOList.add(healthCenterDTO);
        }
        return healthCenterDTOList;
    }

}
