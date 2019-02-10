package com.engi.webgabinet.services;

import com.engi.webgabinet.repositories.HealthCentreDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HealtCentreServiceTest {

    @MockBean
    private HealthCentreDAO healthCentreDAO;
    private HealthCenterService healthCenterService;

    @BeforeEach
    public void setUp() throws Exception {
        this.healthCentreDAO = Mockito.mock(HealthCentreDAO.class);
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Rzuca wyjątek jeśli brak Gabinetu w bazie")
    public void Should_throwException_When_UserDoesNotExist() {
        String email = "foo@bar.com";
        Mockito.when(this.healthCentreDAO.findAll()).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.healthCenterService.findAll()).isInstanceOf(NullPointerException.class)
                .hasMessage(null);
    }
}
