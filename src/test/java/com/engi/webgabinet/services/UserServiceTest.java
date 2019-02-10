package com.engi.webgabinet.services;


import com.engi.webgabinet.exceptions.UnmatchingUserCredentialsException;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.repositories.UserDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



@ExtendWith(SpringExtension.class)
@Tag("Service")
public class UserServiceTest {

    @MockBean
    private UserDAO userDAO;

    private UserService userService;

    @BeforeEach
    public void setUp() throws Exception {
		this.userDAO = Mockito.mock(UserDAO.class);
		MockitoAnnotations.initMocks(this);
        this.userService = new UserServiceImpl(this.userDAO);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Rzuca wyjątek jeśli brak Usera w bazie")
    public void Should_throwException_When_UserDoesNotExist() {
        String email = "foo@bar.com";
        Mockito.when(this.userDAO.findByEmail(email)).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.userService.doesUserExist(email)).isInstanceOf(UserNotFoundException.class)
                .hasMessage("brak usera w bazie");
    }

    @Test
	@DisplayName("Rzuca wyjątek jeśli  User z zadanym emailem i hasłem nie istnieje w bazie")
	public void Should_throwException_When_UnmatchingUserCredentialsFound() {
        String email = "foo@bar.com";
        String password = "xxx";
        Mockito.when(this.userDAO.findByEmail(email)).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.userService.isValidUser(email, password)).isInstanceOf(UnmatchingUserCredentialsException.class)
                .hasMessage("User o tych danych nie istnieje");

    }
}
