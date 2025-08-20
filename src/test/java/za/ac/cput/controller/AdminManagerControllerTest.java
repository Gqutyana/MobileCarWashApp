package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.AdminManager;
import za.ac.cput.domain.User;
import za.ac.cput.factory.AdminManagerFactory;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminManagerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "/MobileCarWashApp/adminManagerService";
    private static AdminManager admin;

    @BeforeAll
    static void setup() {

        admin = AdminManagerFactory.createAdminManager(
                "Sasa56","litha","Lithabo",
                8898642687538L, 2798643567L,
                "litha@gmail.com", "password434", "email"
        );
    }

    @Test
    @Order(1)
    void a_create() {

        String url = BASE_URL + "/create"  ;
        ResponseEntity<AdminManager> postResponse =this. restTemplate.postForEntity(url, admin, AdminManager.class);
        assertNotNull(postResponse);
        AdminManager adminSaved = postResponse.getBody();
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(200, postResponse.getStatusCodeValue());
        assertNotNull(adminSaved);
        assertEquals(admin.getAdminManagerId(), adminSaved.getAdminManagerId());
        assertNotNull(postResponse.getBody(), "Response body should not be null");

        System.out.println("Created: " + adminSaved);
    }

    @Test
    @Order(2)
    void b_read() {
        String url = BASE_URL + "/read/"  + admin.getAdminManagerId();;
        ResponseEntity<AdminManager> response = restTemplate.getForEntity(url, AdminManager.class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println("Reading: " + admin);

    }

    @Test
    @Order(3)
    void c_update() {
        AdminManager updated = new AdminManager.Builder()
                .copy(admin)
                .setFirstName("Alunge")
                .build();
        String url = BASE_URL + "/update";
        this.restTemplate.put(url,updated);
        ResponseEntity<AdminManager> response = restTemplate.getForEntity(BASE_URL + "/read/" + updated.getAdminManagerId(),AdminManager.class);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println("updated: " + updated);
    }

    @Test
    @Order(4)
    void e_delete() {
        String url = BASE_URL + "/delete/" + admin.getAdminManagerId();
        restTemplate.delete(url);
        ResponseEntity<AdminManager> response = restTemplate.getForEntity(BASE_URL + "/read/" + admin.getAdminManagerId(), AdminManager.class);
        assertNull(response.getBody());
        System.out.println("Deleted:" + true);
    }

    @Test
    @Order(5)
    void d_findAll() {
        String url = BASE_URL + "/findAll";
        ResponseEntity<AdminManager[]> response = this.restTemplate.getForEntity(url , AdminManager[].class);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        System.out.println("Get all: ");
        for(AdminManager admin : response.getBody()){
            System.out.println(admin);
        }
    }
}
