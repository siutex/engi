package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.Equipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EquipmentDaoImpl implements EquipmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EquipmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Equipment> findByEquipmentName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Equipment> query = session.getNamedQuery("findByEquipmentName");
        query.setParameter("name", name);
        List<Equipment> equipments = query.getResultList();
        return equipments;

    }

    @Override
    public List<Equipment> findAllEquip() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Equipment> query = session.getNamedQuery("findAllEquipment");
        List<Equipment> equipmentList = query.getResultList();
        return equipmentList;
    }

    @Override
    public Equipment findByEquipmentId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Equipment> query = session.getNamedQuery("findEquipmentById");
        query.setParameter("id", userId);
        List<Equipment> equipmentList = query.getResultList();
        return equipmentList.get(0);
    }

    @Override
    public Equipment save(Equipment equipment) {
        Session session = this.sessionFactory.openSession();
        session.save(equipment);
        session.close();
        return equipment;
    }
}
