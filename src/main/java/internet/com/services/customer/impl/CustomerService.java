package internet.com.services.customer.impl;

import internet.com.dto.customer_dto.ICustomerDTO;
import internet.com.entity.customer.Customer;
import internet.com.repository.customer_repo.ICustomerRepository;
import internet.com.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<ICustomerDTO> searchCustomerByProvince(String province, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay="0000-00-00";
        }
        if(endDay.equals("")){
            endDay="9999-12-31";
        }
        return customerRepository.searchCustomerByProvince('%' + province + '%',
                '%' + name + '%',
                '%' + activeStatus + '%',
                 starDay ,
                 endDay ,
                pageable);
    }

    @Override
    public Page<ICustomerDTO> searchCustomerByDistrict(String district, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay="0000-00-00";
        }
        if(endDay.equals("")){
            endDay="9999-12-31";
        }
        return customerRepository.searchCustomerByDistrict('%' + district + '%',
                '%' + name + '%',
                '%' + activeStatus + '%',
                 starDay,
                 endDay ,
                pageable);
    }

    @Override
    public Page<ICustomerDTO> searchCustomerByCommune(String commune, String name, String activeStatus, String starDay, String endDay, Pageable pageable) {
        if (starDay.equals("")) {
            starDay="0000-00-00";
        }
        if(endDay.equals("")){
            endDay="9999-12-31";
        }
        return customerRepository.searchCustomerByCommune('%' + commune + '%',
                '%' + name + '%',
                '%' + activeStatus + '%',
                  starDay ,
                  endDay ,
                pageable);
    }


}
