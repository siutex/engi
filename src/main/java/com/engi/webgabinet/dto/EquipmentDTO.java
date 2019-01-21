package com.engi.webgabinet.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EquipmentDTO {
    private int id;
    private String equipmentName;
    private int quantity;
    private String producer;
    private boolean isMaintenance;
    private boolean isControled;
    private String serviceNumber;
    private Timestamp lastUpdated;
    private int healthCentreId;
}
