package internet.com.services.customer;

import internet.com.entity.customer.Customer;

import java.util.Optional;

public interface ICustomerService {

    /**
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * @param id
     */
    Optional<Customer> findCustomerById(Integer id);

}
