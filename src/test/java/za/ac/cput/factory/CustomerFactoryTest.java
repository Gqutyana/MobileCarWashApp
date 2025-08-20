
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void testCreateCustomerSuccess() {
        Address address = new Address("123", "Dorset Street", "Cape Town", "Western Cape", "8000");
        Customer customer = CustomerFactory.createCustomer(
                "Anele", "Doe", "Toyota Corolla", 3, true, false,
                "ABSA", 1234567890, 9901011234087L,
                821234567, "john@example.com", "SMS",
                "password123", address
        );

        assertNotNull(customer);
        assertEquals("Anele", customer.getFirstName());
        assertEquals("Toyota Corolla", customer.getCarModel());

        System.out.println(customer);

    }

    @Test
    void testCreateCustomerMissingFirstName() {
        Address address = new Address("123", "Dorset Street", "Cape Town", "Western Cape", "8000");
        Customer customer = CustomerFactory.createCustomer(
                null, "Doe", "Corolla Toyota", 3, false, true,
                "Capitec", 123456789, 0304145470, +273868601,"anelejaji03@gmail.com", "SMS",
                "Ace9924", address);
        assertNull(customer);

        System.out.println(customer);
    }

    @Test
    void testCreateCustomerInvalidEmail() {
        Address address = new Address("123", "Dorset Street", "Cape Town", "Western Cape", "8000");
        Customer customer = CustomerFactory.createCustomer(
                "Anele", "Jaji", "Corolla Toyota", 3, false, true,
                "Capitec", 123456789, 0304145470, +273868601,"anelejaji03", "SMS",
                "Ace9924", address);
        assertNull(customer);

        System.out.println(customer);
    }

}

