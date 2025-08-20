package za.ac.cput.factory;


import za.ac.cput.domain.AdminManager;
import za.ac.cput.factory.AdminManagerFactory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminManagerFactoryTest {

    private static AdminManager admin1 = AdminManagerFactory.createAdminManager("Alunge3234","Jay", null, 9987654321093L, 27698765423L, "alunge@gmail.com", "password55", "sms");

    private static AdminManager admin2 = AdminManagerFactory.createAdminManager("Jojo65456","Viwe", "Jack",  8898642687537L, 2798643567L, "viwe@gmail.com", "password66", "email");

    private static AdminManager admin3 = AdminManagerFactory.createAdminManager("Ace567","Sipho216", "Nkosana",  987642369965L, 2L, "siphogmailcom", "9864out", "sms");

    @Test
    public void testCreateAdminFailure_NullFields() {
        assertNull(admin1);
        System.out.println("admin1 creation failed due to null field");
    }

    @Test
    public void testCreateAdminWithAllAttributes() {
        assertNotNull(admin2);
        System.out.println("Admin created successfully: " + admin2.toString());
    }

    @Test
    public void testCreateAdminThatFails() {
        assertNull(admin3);
        System.out.println("admin3 creation failed due to invalid email.");
    }
}
