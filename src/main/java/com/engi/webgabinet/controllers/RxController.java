package com.engi.webgabinet.controllers;

import com.engi.webgabinet.domain.Doctor;
import com.engi.webgabinet.domain.Rx;
import com.engi.webgabinet.domain.User;
import com.engi.webgabinet.dto.RxDTO;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.services.DoctorService;
import com.engi.webgabinet.services.RxService;
import com.engi.webgabinet.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RxController {
    final static Logger logger = LoggerFactory.getLogger(RxController.class);

    @Autowired
    RxService rxService;

    @Autowired
    UserService userService;

    @Autowired
    DoctorService docService;


    @GetMapping(value = "/rx", produces = "application/json")
    public List<RxDTO> getRx(ModelMap model) {
        List<Rx> rxList;
        User user = getUser();
        if (user.getRole() == 1) {
            rxList = rxService.findByDoctorId(user.getId());
        } else {
            rxList = rxService.findByPatientId(user.getId());
        }
        List<RxDTO> rxDTOList = new ArrayList<RxDTO>();
        for (Rx rx : rxList) {
            RxDTO rxDTO = new RxDTO();
            rxDTO.setMedicine(rx.getMedicine());
            rxDTO.setSymptoms(rx.getSymptoms());
            rxDTO.setPatientName(rx.getUser().getFirstname());
            rxDTOList.add(rxDTO);
        }
        return rxDTOList;
    }

    @PostMapping(value = "/rx/new", produces = "application/json")
    public Rx createRx(ModelMap model, @RequestBody RxDTO reqRx) {
        Rx rx = new Rx();
        rx.setMedicine(reqRx.getMedicine());
        rx.setSymptoms(reqRx.getSymptoms());
        User patient = null;
        try {
            patient = userService.getByEmail(reqRx.getPatientId());
        } catch (UserNotFoundException e) {
        }
        rx.setUser(patient);
        Doctor doctor = docService.findByUserEmailAddress(getUserEmailAddress());
        rx.setDoctor(doctor);
        rxService.save(rx);
        return rx;
    }

    private User getUser() {
        String userEmailAddress = getUserEmailAddress();
        User user = null;
        try {
            user = userService.doesUserExist(userEmailAddress);
        } catch (UserNotFoundException e) {
        }
        return user;
    }

    private String getUserEmailAddress() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

}
