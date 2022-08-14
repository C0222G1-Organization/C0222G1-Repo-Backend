package internet.com.services.customer;

import internet.com.dto.customer_dto.CustomerDTO;
import internet.com.entity.customer.Customer;

import java.util.Optional;

public interface ICustomerService {

    /**
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * @param id
     */
    Optional<Customer> findCustomerById(Integer id);

    Boolean existsEmail(String email);

    Boolean existsPhoneNumber(String phone);

    void saveCustomer(CustomerDTO customerDTO);

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @param customer
     */
    void update(Customer customer);}
