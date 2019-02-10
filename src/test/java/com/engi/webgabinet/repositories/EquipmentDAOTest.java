package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.Doctor;
import com.engi.webgabinet.domain.Equipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Tag("DAO")
public class EquipmentDAOTest {

    @MockBean
    private SessionFactory sessionFactory;
    @MockBean
    private Session session;
    private EquipmentDAO equipmentDAO;
    private List<Equipment> equipmentList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws Exception {
        Mockito.when(this.sessionFactory.getCurrentSession()).thenReturn(this.session);
        this.equipmentDAO = new EquipmentDaoImpl(this.sessionFactory);
        Equipment equipment = new Equipment();
        equipment.setEquipmentName("test");
        Equipment equipment1 = new Equipment();
        equipment1.setEquipmentName("test1");
        equipmentList.add(equipment);
        equipmentList.add(equipment1);
    }

    @Test
    public void should_returnEmptyList_forEmptyrepo() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findAllEquipment")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());

        List list = equipmentDAO.findAllEquip();
        assertAll("Equipments",
                () -> assertNotEquals(list, null),
                () -> assertEquals(list.size(), 0));
    }
    @Test
    public void should_findAll_Equip() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findAllEquipment")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(equipmentList);

        List list = equipmentDAO.findAllEquip();
        assertAll("Equipments",
                () -> assertNotEquals(list, null),
                () -> assertEquals(list.size(), 2));
    }
}

