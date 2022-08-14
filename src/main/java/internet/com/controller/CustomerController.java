package internet.com.controller;

import internet.com.dto.customer_dto.CustomerDTO;
import internet.com.dto.customer_dto.EmailDTO;
import internet.com.dto.customer_dto.PhoneDTO;
import internet.com.dto.customer_dto.UserDTO;
import internet.com.entity.customer.Commune;
import internet.com.entity.customer.Customer;
import internet.com.entity.customer.District;
import internet.com.entity.customer.Province;
import internet.com.entity.user.AppUser;
import internet.com.services.address.IAddressService;
import internet.com.services.customer.ICustomerService;
import internet.com.services.user.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAddressService addressService;

    /**
     * Created by: HaoNH
     * Date Created: 09/06/2022
     * method save customer
     *
     * @param customerDTO
     * @param bindingResult
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            Map<String, String> errorList = new LinkedHashMap<>();
            for (FieldError item : errors) {
                String field = item.getField();
                String msg = item.getDefaultMessage();
                errorList.put(field, msg);
            }
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        }
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * load customer info from database by id parameter
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id){
        Optional<Customer> customer = this.customerService.findCustomerById(id);
        if(!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 13/08/2022
     * @param id
     * @return
     */
    @GetMapping("getCustomer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Integer id){
        Optional<Customer> customer = this.customerService.findCustomerById(id);
        if(!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CustomerDTO customerDTO = new CustomerDTO(
                customer.get().getId(),
                customer.get().getName(),
                customer.get().getDateOfBirth(),
                new EmailDTO(customer.get().getId(), customer.get().getEmail()),
                new PhoneDTO(customer.get().getId(), customer.get().getPhoneNumber()),
                new UserDTO(customer.get().getId(), customer.get().getUser().getUsername()),
                customer.get().getUser().getPassword(),
                customer.get().getCommune(),
                customer.get().getActiveStatus()
        );

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @param id
     * @param customerDTO
     * @param bindingResult
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerDTO
            customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customerEdit = customerService.findCustomerById(id).get();
        if (customerEdit.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerEdit.getUser().setPassword(customerDTO.getPassword());
        customerEdit = modelMapper.map(customerDTO, Customer.class);
        AppUser appUser = new AppUser();
        appUser.setUsername(customerDTO.getUserName().getUserName());
        appUser.setPassword(customerDTO.getPassword());
        customerEdit.setCommune(customerDTO.getCommune());
        iUserService.updateUser(appUser);
        customerService.update(customerEdit);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return list provinces
     */
    @GetMapping("/address/province")
    public ResponseEntity<?> getAllProvinces(){
        List<Province> provinces = this.addressService.findAllProvince();
        if(provinces.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @param id
     * @return an object corresponding to id
     */
    @GetMapping("address/district/{id}")
    public ResponseEntity<?> getAllProvinceById(@PathVariable Integer id){
        List<District> districts = this.addressService.findAllDistrict(id);
        if(districts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return list districts
     */
    @GetMapping("/address/commune/{id}")
    public ResponseEntity<?> getAllDistricts(@PathVariable Integer id){
        List<Commune> communes = this.addressService.findAllCommune(id);
        if(communes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communes, HttpStatus.OK);
    }
    
}
