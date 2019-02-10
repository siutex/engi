package com.engi.webgabinet.repositories;

import com.engi.webgabinet.domain.Doctor;
import com.engi.webgabinet.domain.User;
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
public class DoctorDAOTest {
    @MockBean
    private SessionFactory sessionFactory;
    @MockBean
    private Session session;
    private DoctorDAO doctorDAO;
    private List<Doctor> doctors = new ArrayList<>();

    @BeforeEach
    public void setUp() throws Exception {
        Mockito.when(this.sessionFactory.getCurrentSession()).thenReturn(this.session);
        this.doctorDAO = new DoctorDAOImpl(this.sessionFactory);
        User user = new User();
        User user1 = new User();
        Doctor doctor = new Doctor();
        Doctor doctor1 = new Doctor();
        doctor.setUser(user);
        doctor.setId(0);
        doctor1.setUser(user1);
        doctor1.setId(1);
        doctors.add(doctor);
        doctors.add(doctor1);
    }

    @Test
    public void should_returnEmptyList_forEmptyrepo() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findAll")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());

        List list = doctorDAO.findAll();
        assertAll("Doctors",
                () -> assertNotEquals(list, null),
                () -> assertEquals(list.size(), 0));
    }
    @Test
    public void should_returnList_of_Doctor_byId() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findById")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(doctors);

        Doctor doctor = doctorDAO.findByUserId(0);
        assertAll("Doctors",
                () -> assertNotEquals(null, doctor));

    }
    @Test
    public void should_returnList_of_AllDoctors() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findAll")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(doctors);

        List list = doctorDAO.findAll();
        assertAll("Doctors",
                () -> assertNotEquals(null, list),
                () -> assertEquals(2, list.size()));
    }
}
