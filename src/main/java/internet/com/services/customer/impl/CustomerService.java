package internet.com.services.customer.impl;


import internet.com.dto.customer_dto.CustomerDTO;
import internet.com.dto.customer_dto.ICustomerDTO;
import internet.com.entity.customer.Customer;
import internet.com.repository.customer_repo.ICustomerRepository;
import internet.com.services.customer.ICustomerService;
import internet.com.services.user.IRoleService;
import internet.com.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return this.customerRepository.findByIdCustomer(id);
    }


    /**
     * Created by: TrungTHQ
     * Date Created: 09/08/2022
     * method search customer list
     */
    @Override
    public Page<ICustomerDTO> searchCustomerByProvince(String province, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay = "0000-00-00";
        }
        if (endDay.equals("")) {
            endDay = "9999-12-31";
        }
        return customerRepository.searchCustomerByProvince('%' + province + '%',
                                                            '%' + name + '%',
                                                            '%' + activeStatus + '%',
                                                            starDay,
                                                            endDay,
                                                            pageable);
    }


    /**
     * Created by: TrungTHQ
     * Date Created: 09/08/2022
     * method search customer list
     */
    @Override
    public Page<ICustomerDTO> searchCustomerByDistrict(String district, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay = "0000-00-00";
        }
        if (endDay.equals("")) {
            endDay = "9999-12-31";
        }
        return customerRepository.searchCustomerByDistrict('%' + district + '%',
                '%' + name + '%',
                '%' + activeStatus + '%',
                starDay,
                endDay,
                pageable);
    }

    /**
     * Created by: TrungTHQ
     * Date Created: 09/08/2022
     * method search customer list
     */
    @Override
    public Page<ICustomerDTO> searchCustomerByCommune(String commune, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay = "0000-00-00";
        }
        if (endDay.equals("")) {
            endDay = "9999-12-31";
        }
        return customerRepository.searchCustomerByCommune('%' + commune + '%',
                '%' + name + '%',
                '%' + activeStatus + '%',
                starDay,
                endDay,
                pageable);
    }

    /**
     * Created by: TrungTHQ
     * Date Created: 013/08/2022
     * method delete customer
     */
    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteCustomerById(id);
    }

    /**
     * Created by: HaoNH
     * Date Created: 09/08/2022
     * method save customer
     *
     * @param customerDTO
     */
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

        String encodedPassword = passwordEncoder.encode(customerDTO.getPassword());
        userService.createUser(customerDTO.getUserName().getUserName(), encodedPassword);
        roleService.addNewCustomerUserRole(customerDTO.getUserName().getUserName());
        customerRepository.saveCustomer(customerDTO.getName(),
                customerDTO.getDateOfBirth(),
                customerDTO.getEmail().getEmail(),
                customerDTO.getPhoneNumber().getPhone(),
                customerDTO.getUserName().getUserName(),
                customerDTO.getCommune().getId());
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     *
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        customerRepository.update(
                customer.getName(),
                customer.getDateOfBirth(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getActiveStatus(),
                customer.getCommune().getId(),
                customer.getId()
        );
    }


    /**
     * Created by: HaoNH
     * Date Created: 11/08/2022
     * method check email is exits
     *
     * @param email
     * @return
     */
    @Override
    public Boolean existsEmail(String email) {
        return email.equals(customerRepository.existsEmail(email));
    }

    /**
     * Created by: HaoNH
     * Date Created: 11/08/2022
     * method check email is exits
     *
     * @param phone
     * @return
     */
    @Override
    public Boolean existsPhoneNumber(String phone) {
        return phone.equals(customerRepository.existsPhone(phone));
    }

    /**
     * Create by HoangHN
     * Date create: 13/08/2022
     * method find Email get username
     *
     * @param email
     * @return
     */
    @Override
    public String findByEmailGetUsername(String email) {
        return customerRepository.findByEmailGetUsername(email);
    }


    /**
     * Create by HoangHN
     * Date create: 13/08/2022
     * method find Customer By User Name
     *
     * @param username
     * @return
     */
    @Override
    public Optional<Customer> findCustomerByUserName(String username) {
        return customerRepository.findCustomerByUserName(username);
    }

    /**
     * Create by HoangHN
     * Date create: 13/08/2022
     * method get Remaining Time
     *
     * @return
     */
    @Override
    public Integer getRemainingTime(Integer id) {
        return customerRepository.getRemainingTime(id);
    }
}
