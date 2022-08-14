package internet.com.repository.customer_repo;

import internet.com.entity.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    /**
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * @param customerId
     * @return
     */
    @Query(value = "SELECT id, customer_name, date_of_birth,phone_number, email, active_status, delete_status, " +
            "remaining_time, user_name, address_id FROM customer WHERE id =:customerId", nativeQuery = true)
    Optional<Customer> findByIdCustomer(@Param("customerId") Integer customerId);

    /**
     * Created by: HaoNH
     * Date Created: 09/06/2022
     * method save customer
     *
     * @param name
     * @param dateOfBirth
     * @param email
     * @param phone
     * @param userName
     * @param address
     */
    @Modifying
    @Query(value = "INSERT INTO customer(customer_name, date_of_birth, email, phone_number, remaining_time, user_name, address_id) VALUE " +
            "( :name, :dateOfBirth, :email, :phone, 0, :userName, :address)", nativeQuery = true)
    void saveCustomer(@Param("name") String name,
                      @Param("dateOfBirth") String dateOfBirth,
                      @Param("email") String email,
                      @Param("phone") String phone,
                      @Param("userName") String userName,
                      @Param("address") Integer address);

    /**
     * Create by HaoNH
     * Date create: 11/09/2022
     * method check email is exits
     *
     * @param email
     * @return
     */
    @Query(value = "SELECT email FROM customer where email = :email", nativeQuery = true)
    String existsEmail(@Param("email") String email);

    /**
     * Create by HaoNH
     * Date create: 11/09/2022
     * method check phone is exits
     *
     * @param phone
     * @return
     */
    @Query(value = "SELECT phone_number FROM customer where phone_number = :phone", nativeQuery = true)
    String existsPhone(@Param("phone") String phone);

    /**
     * Create by CuongTM
     * Date create: 11/08/2022
     * method update customer
     * @param name
     * @param dateOfBirth
     * @param email
     * @param phoneNumber
     * @param activeStatus
     * @param communeId
     * @param customerId
     */
    @Modifying
    @Query(value = " UPDATE customer SET customer_name=:name, date_of_birth=:dateOfBirth,phone_number=:phoneNumber, " +
            "email=:email, " +
            " active_status=:activeStatus, address_id=:communeId WHERE id=:customerId", nativeQuery = true)
    void update(@Param("name") String name, @Param("dateOfBirth") String dateOfBirth,
                @Param("email") String email,
                @Param("phoneNumber") String phoneNumber,
                @Param("activeStatus") Integer activeStatus,
                @Param("communeId") Integer communeId,
                @Param("customerId") Integer customerId);

}

