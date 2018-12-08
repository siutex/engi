package com.engi.webgabinet.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name="equipment")
public class Equipment implements java.io.Serializable{

private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "equipment_name")
    private String equipmentName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "producer")
    private String producer;
    @Column(name = "is_maintenance")
    private boolean isMaintenance;
    @Column(name = "is_controled")
    private boolean isControled;
    @Column(name = "service_number")
    private String serviceNumber;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

}
