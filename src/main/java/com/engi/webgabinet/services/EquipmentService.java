package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.Equipment;
import java.util.List;

public interface EquipmentService {

	void save(Equipment equipment);
	
	List<Equipment> findByEquipmentName(String  equipmentName);
	
	Equipment findByEquipmentId(int userId);

	List<Equipment> findAll();
}
