package internet.com.controller;

import internet.com.entity.customer.Customer;
import internet.com.services.customer.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

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
}
