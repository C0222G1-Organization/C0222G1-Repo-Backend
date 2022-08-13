package internet.com.repository.customer_repo;

import internet.com.entity.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

    /**
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * @param customerId
     * @return
     */
    @Query(value = "SELECT id, customer_name, date_of_birth,phone_number, email, active_status, delete_status, " +
            "remaining_time, user_name, address_id FROM customer WHERE id =:customerId", nativeQuery = true)
    Optional<Customer> findByIdCustomer(@Param("customerId") Integer customerId);
}

