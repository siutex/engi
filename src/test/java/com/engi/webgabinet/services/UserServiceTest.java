package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.User;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.repositories.UserDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



@ExtendWith(SpringExtension.class)
@Tag("Service")
public class UserServiceTests {

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
   // @RepeatedTest(5)
    @DisplayName("Rzuca wyjątek jeśli brak Usera w bazie")
    public void Should_throwException_When_UserDoesNotExist() {
        String email = "foo@bar.com";
        Mockito.when(this.userDAO.findByEmail(email)).thenReturn(new ArrayList<>());
        assertThatThrownBy(() -> this.userService.doesUserExist(email)).isInstanceOf(UserNotFoundException.class)
                .hasMessage("brak usera w bazie");
    }

    @Test
	@DisplayName("Throws exception if user with given email & password is not found in the database")
	public void Should_throwException_When_UnmatchingUserCredentialsFound() {
		fail("Not yet implemented"); }
}
