package internet.com.services.customer.impl;

import internet.com.entity.customer.Customer;
import internet.com.repository.customer_repo.ICustomerRepository;
import internet.com.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return this.customerRepository.findByIdCustomer(id);
    }
}
