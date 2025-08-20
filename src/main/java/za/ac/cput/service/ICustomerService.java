package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.FullWash;

import java.util.List;

public interface ICustomerService extends IService<Customer, Long> {
    List<Customer> getAll();
}
