package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private CustomerRepository repository;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        repository = (CustomerRepository) CustomerRepository.createRepository();
        repository.getAll().clear(); // clean list before each test

        Address address = new Address("10", "Dorset St", "Cape Town", "Western Cape", "8001");
        customer1 = CustomerFactory.createCustomer(
                "Anele", "Jaji", "Toyota Corolla", 3,
                true, false, "ABSA", 1234567890,
                9901011234087L, 825171968,
                "anele@gmail.com", "SMS", "password",
                address
        );

        customer2 = CustomerFactory.createCustomer(
                "Lisa", "Jojo", "VW Polo", 2,
                false, true, "Capitec", 987654321,
                8805056789089L, 761111222,
                "Jeeyjeey@gmail.com", "Email", "passJOJO",
                address
        );
    }

    @Test
    void Create() {
        Customer create = repository.create(customer1);
        assertNotNull(create);
        assertEquals(customer1.getCustomerId(), create.getCustomerId());

        System.out.println(create);
    }

    @Test
    void Read() {
        repository.create(customer1);
        Customer readCustomer = repository.read(customer1.getCustomerId());
        assertNotNull(readCustomer);
        assertEquals("Anele", readCustomer.getFirstName());

        System.out.println(readCustomer);
    }

    @Test
    void Update() {
        repository.create(customer1);
        Customer updated = new Customer.Builder()
                .copy(customer1)
                .setCarModel("BMW X5")
                .build();

        Customer result = repository.update(updated);
        assertNotNull(result);
        assertEquals("BMW X5", result.getCarModel());

        System.out.println(result);
    }

    @Test
    void Delete() {
        repository.create(customer1);
        boolean deleted = repository.delete(customer1.getCustomerId());
        assertTrue(deleted);
        assertNull(repository.read(customer1.getCustomerId()));

        System.out.println(deleted);
    }

    @Test
    void testGetAll() {
        repository.create(customer1);
        repository.create(customer2);
        List<Customer> customers = repository.getAll();
        assertEquals(2, customers.size());

        System.out.println(customers);
    }
}
