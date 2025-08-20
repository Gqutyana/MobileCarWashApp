////package za.ac.cput.service;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import za.ac.cput.domain.Customer;
////import za.ac.cput.Repository.CustomerRepository;
////
////import java.util.List;
////
////
////@Service
////public class CustomerService implements ICustomerService {
////
////    private static CustomerRepository repository;
////
////    @Autowired
////    public CustomerService(CustomerRepository repository) {
////        this.repository = repository;
////    }
////
////    @Override
////    public List<Customer> findByAddressId(Long id) {
////        return repository.findAll()
////                .stream()
////                .filter(c -> c.getAddress() != null && id.equals(c.getAddress().getId()))
////                .toList();
////    }
////
////    @Override
////    public List<Customer> getAll() {
////        return repository.findAll();
////    }
////
////    @Override
////    public Customer create(Customer customer) {
////        return repository.save(customer);
////    }
////
////    @Override
////    public Customer read(Long id) {
////        return repository.findById(id).orElse(null);
////    }
////
////    @Override
////    public Customer update(Customer customer) {
////        if (repository.existsById(customer.getCustomerId())) {
////            return repository.save(customer);
////        }
////        return null;
////    }
////}
//
//package za.ac.cput.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.Customer;
//import za.ac.cput.Repository.CustomerRepository;
//
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class CustomerService implements ICustomerService {
//
//    @Autowired
//
//    private static ICustomerService customerService;
//
//    private CustomerRepository repository;
//
//    public CustomerService() {
//        this.repository = CustomerRepository.createRepository();// factory-style repo
//        this.repository
//    }
//
//    @Override
//    public Customer create(Customer customer) {
//        return repository.create(customer);
//    }
//
//    @Override
//    public Customer read(Long along) {
//        return repository.read(along);
//    }
//
//
//    @Override
//    public Customer update(Customer customer) {
//        return repository.update(customer);
//    }
//
//
//    @Override
//    public List<Customer> getAll() {
//        return this.repository.getAll();
//    }
//}
//

package za.ac.cput.service;

import za.ac.cput.Repository.CustomerRepository;
import za.ac.cput.Repository.ICustomerRepository;
import za.ac.cput.domain.Customer;

import java.util.List;

public class CustomerService implements ICustomerService {

    private final ICustomerRepository repository;

    public CustomerService() {
        this.repository = CustomerRepository.createRepository();
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer read(Long id) {
        return repository.read(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }


    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }
}

