package com.engi.webgabinet.repositories;

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
public class RxDAOTest {
    @MockBean
    private SessionFactory sessionFactory;
    @MockBean
    private Session session;

    private RxDAO rxDAO;

    @BeforeEach
    public void setUp() throws Exception {
        Mockito.when(this.sessionFactory.getCurrentSession()).thenReturn(this.session);
        this.rxDAO = new RxDAOImpl(this.sessionFactory);
    }

    @Test
    public void should_returnEmptyList_forEmptyrepo() {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findByDoctorId")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());
        int mockId = 999;

        List list = rxDAO.findByDoctorId(mockId);
        assertAll("Equipments",
                () -> assertNotEquals(list, null),
                () -> assertEquals(list.size(), 0));
    }
}
