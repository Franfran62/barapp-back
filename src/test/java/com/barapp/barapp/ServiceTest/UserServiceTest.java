import com.barapp.barapp.Dto.UserCreateDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Repository.UserRepository;
import com.barapp.barapp.Service.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("Test");
        userCreateDto.setPassword("Password123");

        when(userRepository.existsByUsername("Test")).thenReturn(false);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(new UserEntity());

        Boolean result = userService.createUser(userCreateDto);

        assertTrue(result);
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testCreateUserWithInvalidPassword() {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("Test");
        userCreateDto.setPassword("invalid");

        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(userCreateDto);
        });

        verify(userRepository, times(0)).save(any(UserEntity.class));
    }

    @Test
    public void testFindByUsername() {
        when(userRepository.findByUsername("Test")).thenReturn(new UserEntity());

        UserEntity result = userService.findByUsername("Test");

        assertNotNull(result);
    }

    @Test
    public void testReturnLastConnectionFromUsername() {
        UserEntity user = new UserEntity();
        user.setLastConnection(new Date());

        when(userRepository.findByUsername("Test")).thenReturn(user);

        Date result = userService.returnLastConnectionFromUsername("Test");

        assertNotNull(result);
    }
}