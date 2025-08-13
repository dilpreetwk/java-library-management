package org.example.java.libraray.management.repository;

import org.example.java.libraray.management.exception.GlobalException;
import org.example.java.libraray.management.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRepositoryTest {

    private UserRepository userRepository;
    private final Long usersSeeded = 3L;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void findById_UserPresent_ShouldReturnUser() {
        User user = userRepository.findById(1L);

        assertNotNull(user);
        assertEquals(1L, user.getId());
    }

    @Test
    void findById_UserNotPresent_ShouldThrowException() {
        GlobalException ex = assertThrows(GlobalException.class, () -> userRepository.findById(999L));
        assertEquals("User not found with id: 999", ex.getMessage());
    }

    @Test
    void add_ShouldAutoAssignId() {
        User newUser = sampleUser();
        assertNull(newUser.getId());

        User addedUser = userRepository.add(newUser);
        assertNotNull(addedUser);
        assertEquals(usersSeeded + 1, addedUser.getId());
    }

    @Test
    void findAll_ShouldReturnSeededUsers() {
        assertEquals(usersSeeded, userRepository.findAll().size());
    }

    private User sampleUser() {
        User user = new User();
        user.setName("user");
        user.setEmail("email");
        return user;
    }
}
