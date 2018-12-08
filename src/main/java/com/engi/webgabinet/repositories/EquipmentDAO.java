package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.Equipment;



import java.util.List;

public interface EquipmentDAO {
    List<Equipment> findByEquipmentName(String name);

    List<Equipment> findAllEquip();

    Equipment findByEquipmentId(int userId);

    Equipment save(Equipment equipment);
}
