package com.engi.webgabinet.controllers;

import com.engi.webgabinet.domain.Doctor;
import com.engi.webgabinet.domain.Equipment;
import com.engi.webgabinet.domain.Rx;
import com.engi.webgabinet.domain.User;
import com.engi.webgabinet.dto.EquipmentDTO;
import com.engi.webgabinet.dto.RxDTO;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.services.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EquipmentController {

    final static Logger logger = LoggerFactory.getLogger(com.engi.webgabinet.controllers.HealthCenterController.class);

    @Autowired
    EquipmentService equipmentService;


    @GetMapping(value = "/equipment", produces = "application/json")
    public List<EquipmentDTO> getEquip (ModelMap model) {
        List<Equipment> equipmentList = equipmentService.findAll();
        List<EquipmentDTO> equipmentDTOS = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            EquipmentDTO equipmentDTO = new EquipmentDTO();
            equipmentDTO.setId(equipment.getId());
            equipmentDTO.setEquipmentName(equipment.getEquipmentName());
            equipmentDTO.setQuantity(equipment.getQuantity());
            equipmentDTO.setServiceNumber(equipment.getServiceNumber());
            equipmentDTO.setProducer(equipment.getProducer());
            equipmentDTO.setLastUpdated(equipment.getLastUpdated());
            equipmentDTOS.add(equipmentDTO);
        }
        return equipmentDTOS;
    }
    @PostMapping(value="/equipment/new", produces="application/json")
    public Equipment createEquipment(ModelMap model, @RequestBody EquipmentDTO equipReq) {
        Equipment equipment = new Equipment();
        equipment.setEquipmentName(equipReq.getEquipmentName());
        equipment.setProducer(equipReq.getProducer());
        equipment.setQuantity(equipReq.getQuantity());
        equipment.setServiceNumber(equipReq.getServiceNumber());
        equipment.setLastUpdated(equipReq.getLastUpdated());
        equipmentService.save(equipment);
        return equipment;
    }

}


