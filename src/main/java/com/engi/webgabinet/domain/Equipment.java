package com.engi.webgabinet.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name="equipment")
@NamedQueries({
        @NamedQuery(
                name = "findByEquipmentName",
                query = "from Equipment u where u.equipmentName = :equipmentName"
        ),
        @NamedQuery(
                name = "findAllEquipment",
                query = "from Equipment"
        ),
        @NamedQuery(
                name = "findEquipmentById",
                query = "from Equipment h where h.id = :id"
        ),
})
public class Equipment implements java.io.Serializable{

private static final long serialVersionUID = 21L;

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
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JoinColumn(name = "health_centre_id")
   // private HealthCentre healthCentre;
}
