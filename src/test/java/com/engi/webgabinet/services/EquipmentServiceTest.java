package com.engi.webgabinet.services;

import com.engi.webgabinet.repositories.EquipmentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EquipmentServiceTest {

    @MockBean
    private EquipmentDAO equipmentDAO;

    private EquipmentService equipmentService;

    @BeforeEach
    public void setUp() throws Exception {
        this.equipmentDAO = Mockito.mock(EquipmentDAO.class);
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Rzuca wyjątek jeśli brak Sprzętu w bazie")
    public void Should_throwException_When_UserDoesNotExist() {
        String email = "foo@bar.com";
        Mockito.when(this.equipmentDAO.findAllEquip()).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.equipmentService.findAll()).isInstanceOf(NullPointerException.class)
                .hasMessage(null);
    }
}
