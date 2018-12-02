package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.HealthCentre;
import com.engi.webgabinet.repositories.HealthCentreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthCenterServiceImpl implements HealthCenterService {

    private HealthCentreDAO healthCentreDAO;

    @Autowired
    public HealthCenterServiceImpl(HealthCentreDAO healthCentreDAO) {
        this.healthCentreDAO = healthCentreDAO;
    }

    @Override
    public List<HealthCentre> findAll() {
        return healthCentreDAO.findAll();
    }

    @Override
    public int findCount() {
        return healthCentreDAO.findAllCount();
    }


    @Override
    public HealthCentre findById(int id) {
        return healthCentreDAO.findById(id);
    }

    @Override
    public List<HealthCentre> findByName(String name) {
        return healthCentreDAO.findByName(name);
    }
}
