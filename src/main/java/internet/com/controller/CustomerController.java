package internet.com.controller;

import internet.com.dto.customer_dto.CustomerDTO;
import internet.com.entity.customer.Customer;
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
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) {
        Optional<Customer> customer = this.customerService.findCustomerById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }
}
