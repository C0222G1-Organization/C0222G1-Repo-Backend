package internet.com.repository.customer_repo;

import internet.com.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
}

