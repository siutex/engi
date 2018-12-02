package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.HealthCentre;

import java.util.List;

public interface HealthCentreDAO {
    List<HealthCentre> findAll();

    int findAllCount();

    List<HealthCentre> findByName(String name);

    HealthCentre findById(int id);

}
