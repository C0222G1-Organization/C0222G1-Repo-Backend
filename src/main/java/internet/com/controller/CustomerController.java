package internet.com.controller;

import internet.com.dto.customer_dto.ICustomerDTO;
import internet.com.entity.customer.Customer;
import internet.com.services.customer.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    /**
     * Created by: TrungTHQ
     * Date Created: 10/08/2022
     * load customers from database by id parameter
     */

    @GetMapping("/searchCustomer")
    public ResponseEntity<?> searchByAddress(@RequestParam("address") String address, @RequestParam("name") String name,
                                             @RequestParam("activeStatus") String activeStatus,
                                             @RequestParam("starDay") String starDay,
                                             @RequestParam("endDay") String endDay,
                                             @RequestParam(value = "page") int p) {
        Page<ICustomerDTO> list = customerService.searchCustomerByProvince(address, name, activeStatus,starDay,endDay,PageRequest.of(p, 2));
        Page<ICustomerDTO> list1 = customerService.searchCustomerByDistrict(address, name, activeStatus,starDay,endDay, PageRequest.of(p, 2));
        Page<ICustomerDTO> list2 = customerService.searchCustomerByCommune(address, name, activeStatus,starDay,endDay, PageRequest.of(p, 2));
        if (list.getTotalElements() != 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        if (list1.getTotalElements() != 0) {
            return new ResponseEntity<>(list1, HttpStatus.OK);
        }
        if (list2.getTotalElements() != 0) {
            return new ResponseEntity<>(list1, HttpStatus.OK);
        }
        return new ResponseEntity<>(list1, HttpStatus.OK);

    }
}
