package com.engi.webgabinet.services;


import com.engi.webgabinet.exceptions.UnmatchingUserCredentialsException;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.repositories.DoctorDAO;
import com.engi.webgabinet.repositories.UserDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@Tag("Service")
public class DoctorServiceTest {

    @MockBean
    private DoctorDAO doctorDAO;

    @MockBean
    private UserService userService;

    private DoctorService doctorService;

    @BeforeEach
    public void setUp() throws Exception {
        this.doctorDAO = Mockito.mock(DoctorDAO.class);
        MockitoAnnotations.initMocks(this);
        this.doctorService = new DoctorServiceImpl(doctorDAO, userService);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Rzuca wyjątek jeśli brak Doktora w bazie")
    public void Should_throwException_When_DoctorDoesNotExist() {
        String code = "foo@bar.com";
        Mockito.when(this.doctorDAO.findBySpecialityCode(code)).thenReturn(new ArrayList<>());
        assertThat(this.doctorService.findBySpeciality(code)).hasNoNullFieldsOrProperties();
    }
}
