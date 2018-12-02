package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.HealthCentre;

import java.util.List;

public interface HealthCenterService {

    HealthCentre findById(int id);

    List<HealthCentre> findByName(String Name);

    List<HealthCentre> findAll();

    int findCount();


}
