package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import za.ac.cput.Main;
import za.ac.cput.domain.AdminManager;
import za.ac.cput.factory.AdminManagerFactory;
import za.ac.cput.service.AdminManagerService;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Main.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Service
   public class AdminManagerServiceTest {

    @Autowired
    private AdminManagerService service;
    private static AdminManager admin = AdminManagerFactory.createAdminManager("Litha4567","Anathi","Botha",  8898642687537L, 27986435677L, "anathi@gmail.com", "signature888", "email");



    @Test
    @Order(1)
    public void a_create() {

        AdminManager created = service.create(admin);
        assertNotNull(created);
        admin = created;
        assertNotNull(admin.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    public void b_read() {
        System.out.println("Reading Admin with ID: " + admin.getUserId());
        AdminManager read = service.read(admin.getUserId());
        assertNotNull(admin);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    public void c_update() {
        assertNotNull(admin);
        AdminManager updatedAdmin = new AdminManager.Builder()
                .copy(admin)
                .setLastName("Nana")
                .build();

        AdminManager updated = service.update(updatedAdmin);
        assertNotNull(updated);
        assertEquals("Nana", updated.getLastName());
        admin = updated;
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    public void e_getall(){
    System.out.println(service.findAll());
}
}




