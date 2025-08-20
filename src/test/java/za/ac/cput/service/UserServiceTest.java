package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import za.ac.cput.domain.AdminManager;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserServiceTest {

   @Autowired
    private UserService userService;

    private static User user = UserFactory.createUser("Andy343","Nick", "Jomo", 9965836293745L, 2796673838L, "nick@gmail.com", "signature4", "email");

    @Test
    public void a_create() {
       User created = userService.create(user);
        assertNotNull(created);
        assertEquals(user.getUserId(),created.getUserId());
        System.out.println("Created: " + created);

    }

    @Test
    public void b_read() {
        System.out.println("Reading User with ID: " + user.getUserId());
        User read = userService.read(user.getUserId());
        assertNotNull(user);
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        User updatedUser = new User.Builder()
                .copy(user)
                .setFirstName("Zona")
                .build();
        User updated = userService.update(updatedUser);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_getAll() {
        System.out.println(userService.findAll());
    }
}


