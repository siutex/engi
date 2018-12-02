package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.HealthCentre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class HealthCenterDAOImpl implements HealthCentreDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public HealthCenterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<HealthCentre> findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<HealthCentre> query = session.getNamedQuery("findByHealthCenterName");
        query.setParameter("name", name);
        List<HealthCentre> healthCentres = query.getResultList();
        return healthCentres;
    }

    @Override
    public HealthCentre findById(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<HealthCentre> query = session.getNamedQuery("findByIdHealthCenter");
        query.setParameter("id", userId);
        List<HealthCentre> healthCentres = query.getResultList();
        return healthCentres.get(0);
    }


    @Override
    public List<HealthCentre> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<HealthCentre> query = session.getNamedQuery("findAllHealthCenter");
        List<HealthCentre> healthCentres = query.getResultList();
        return healthCentres;
    }

    @Override
    public int findAllCount() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Number> query = session.getNamedQuery("findAllCountHealthCenter");
        int count = ((Number) query.getSingleResult()).intValue();
        return count;
    }
}
