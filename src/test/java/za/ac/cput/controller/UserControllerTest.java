package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "/MobileCarWashApp/userService";
    private static User user;

    @BeforeAll
    static void setup() {
        user = UserFactory.createUser("Ayanda8764", "Anele", "Jojo", 9965836293745L, 2796673838L, "anele@gmail.com", "password521", "email"
        );
    }

    @Test
    @Order(1)
    void a_create() {
        String url =  BASE_URL + "/create";
        ResponseEntity<User> postResponse = this.restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        User userSaved = postResponse.getBody();
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(200, postResponse.getStatusCodeValue());
        assertNotNull(userSaved);
        assertEquals(user.getUserId(), userSaved.getUserId());
        System.out.println(" created :" + userSaved);
    }

    @Test
    @Order(2)
    void b_read() {
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "/read/" + user.getUserId(), User.class);
        assertEquals(200, response.getStatusCodeValue());
        System.out.println("reading: " + user);
    }

    @Test
    @Order(3)
    void c_update() {
        User updated = new User.Builder()
                     .copy(user)
                     .setFirstName("Alungile")
                     .build();
        String url = BASE_URL + "/update";
        this.restTemplate.put(url,updated);

        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "/read/" + updated.getUserId(),User.class);
        assertNotNull(response.getBody());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(200, response.getStatusCodeValue());

        assertEquals(updated.getFirstName() ,    response.getBody().getFirstName());
        System.out.println("updated: " + response.getBody());
    }


    @Test
    @Order(4)
    void e_delete() {
        String url = BASE_URL + "/delete/" + user.getUserId();
        restTemplate.delete(url);
        ResponseEntity<User> response = restTemplate.getForEntity(BASE_URL + "/read/" + user.getUserId(), User.class);
        assertNull(response.getBody());
        System.out.println("Deleted:" + true);

    }

    @Test
    @Order(5)
    void d_findAll() {
        String url = BASE_URL + "/findAll";
        ResponseEntity<User[]> response = this.restTemplate.getForEntity(url , User[].class);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        System.out.println("Get all: ");
        for(User user : response.getBody()){
            System.out.println(user);
        }

    }
}
