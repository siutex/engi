package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.Equipment;
import com.engi.webgabinet.domain.Rx;
import com.engi.webgabinet.repositories.EquipmentDAO;
import com.engi.webgabinet.repositories.RxDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    final static Logger logger = LoggerFactory.getLogger(RxServiceImpl.class);

    @Autowired
    private EquipmentDAO equipmentDAO;

    @Override
    public List<Equipment> findByEquipmentName(String name) {
        return equipmentDAO.findByEquipmentName(name);
    }

    @Override
    public void save(Equipment equipment) {
        equipmentDAO.save(equipment);
    }

    @Override
    public Equipment findByEquipmentId(int id) {
        return equipmentDAO.findByEquipmentId(id);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentDAO.findAllEquip();
    }

}
