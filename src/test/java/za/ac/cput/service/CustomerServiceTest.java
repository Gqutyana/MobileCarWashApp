package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService service;
    private Customer customer;

    @BeforeEach
    void setUp() {
        service = new CustomerService();
        service.getAll().clear(); // clean slate

        Address address = new Address("12", "Dorset St", "Cape Town", "WC", "8000");
        customer = CustomerFactory.createCustomer(
                "Anele", "Jaji", "Toyota Corolla", 2,
                false, true, "FNB", 12345678,
                9701011234567L, 821234567,
                "Anele@gmail.com", "SMS", "pasword", address
        );
    }

    @Test
    void Create() {
        Customer created = service.create(customer);
        assertNotNull(created);
        assertEquals(customer.getCustomerId(), created.getCustomerId());

        System.out.println(created);
    }

    @Test
    void Read() {
        service.create(customer);
        Customer read = service.read(customer.getCustomerId());
        assertNotNull(read);

        System.out.println(read);
    }

    @Test
    void testUpdate() {
        service.create(customer);
        Customer updated = new Customer.Builder()
                .copy(customer)
                .setCarModel("Honda Jazz")
                .build();

        Customer result = service.update(updated);
        assertNotNull(result);
        assertEquals("Honda Jazz", result.getCarModel());

        System.out.println(result);
    }



    @Test
    void testGetAll() {
        service.create(customer);
        List<Customer> customers = service.getAll();
        assertEquals(1, customers.size());

        System.out.println(customers);
    }
}
