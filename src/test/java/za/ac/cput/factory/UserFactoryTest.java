package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserFactoryTest {

    private static User user1 = UserFactory.createUser("Nana432","Alungile", null, 9698756888888L, 27876543218L, "nana@gmail.com", "password33", "sms");

    private static User user2 = UserFactory.createUser("Ayakha55","Nick", "Jola", 9965836293745L, 2796673838L, "nick@gmail.com", "password", "email");

    private static User user3 = UserFactory.createUser("Nono67","James", "Vena", 9765329187327L, 27696754321L, "jamesgmail.com", "password4", "sms");

    @Test
    void testCreateUserFailure_NullFields() {
        assertNull(user1);
        System.out.println("user1 creation failed as expected due to null surname.");
    }

    @Test
    void testCreateUserWithAllAttributes() {
        assertNotNull(user2);
        System.out.println("User2 created: " + user2);
    }

    @Test
    void testCreateUserFailure_InvalidEmail() {
        assertNull(user3);
        System.out.println("user3 creation failed as expected due to invalid email.");
    }
}
