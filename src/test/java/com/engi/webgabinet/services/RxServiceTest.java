package com.engi.webgabinet.services;

import com.engi.webgabinet.repositories.EquipmentDAO;
import com.engi.webgabinet.repositories.RxDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RxServiceTest {

    @MockBean
    private RxDAO rxDAO;

    private RxService rxService;

    @BeforeEach
    public void setUp() throws Exception {
        this.rxDAO = Mockito.mock(RxDAO.class);
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Rzuca wyjątek jeśli brak Sprzętu w bazie")
    public void Should_throwException_When_UserDoesNotExist() {
        int iD = 888;
        Mockito.when(this.rxDAO.findByDoctorId(iD)).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.rxService.findByDoctorId(iD)).isInstanceOf(NullPointerException.class)
                .hasMessage(null);
    }
}
