package internet.com.controller;

import internet.com.dto.customer_dto.CustomerDTO;
import internet.com.dto.customer_dto.ICustomerDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
     * Created by: DuyNT
     * Date Created: 10/08/2022
     * load customer info from database by id parameter
     *
     * @param id
     * @return
     */


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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

    /**
     * Created by: TrungTHQ
     * <p>
     * Date Created: 10/08/2022
     * load customers from database by id parameter
     */
    @GetMapping("/searchCustomer")
    public ResponseEntity<?> searchByAddress(@RequestParam("address") String address,
                                             @RequestParam("name") String name,
                                             @RequestParam("activeStatus") String activeStatus,
                                             @RequestParam("starDay") String starDay,
                                             @RequestParam("endDay") String endDay,
                                             @RequestParam(value = "page") int p) {
        Page<ICustomerDTO> list = customerService.searchCustomerByProvince(address, name, activeStatus, starDay, endDay, PageRequest.of(p, 2));
        Page<ICustomerDTO> list1 = customerService.searchCustomerByDistrict(address, name, activeStatus, starDay, endDay, PageRequest.of(p, 2));
        Page<ICustomerDTO> list2 = customerService.searchCustomerByCommune(address, name, activeStatus, starDay, endDay, PageRequest.of(p, 2));
        if (list.getTotalElements() != 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        if (list1.getTotalElements() != 0) {
            return new ResponseEntity<>(list1, HttpStatus.OK);
        }
        return new ResponseEntity<>(list2, HttpStatus.OK);
    }

    /**
     * Created by: TrungTHQ
     * Date Created: 13/08/2022
     * delete customer by id
     */

    @DeleteMapping("/deleteCustomerBy")
    public ResponseEntity<?> deleteCustomer(@RequestParam("id") Integer id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by:CuongTM
     * Date Created:
     * 11 / 08 / 2022
     *
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
        appUser.setUsername(customerDTO.getUserName().getUsername());
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
    @GetMapping("/provinces")
    public ResponseEntity<?> getAllProvinces(){
        List<Province> provinces = this.addressService.getAllProvinces();
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
    @GetMapping("/provinces/{id}")
    public ResponseEntity<?> getAllProvinceById(@PathVariable Integer id){
        Province province = this.addressService.getProvinceById(id);
        if(province == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return list districts
     */
    @GetMapping("/districts")
    public ResponseEntity<?> getAllDistricts(){
        List<District> districts = this.addressService.getAllDistricts();
        if(districts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @param id
     * @return an objectd district corresponding to id province
     */
    @GetMapping("/districts/province/{id}")
    public ResponseEntity<?> getDistrictsByProvinceId(@PathVariable Integer id){
        List<District> districts = this.addressService.getDistrictsByProvinceId(id);
        if(districts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return list communes
     */
    @GetMapping("/communes")
    public ResponseEntity<?> getAllCommunes(){
        List<Commune> communes = this.addressService.getAllCommunes();
        if(communes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communes, HttpStatus.OK);
    }
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @param id
     * @return an objectd communes corresponding to id district
     */
    @GetMapping("/communes/district/{id}")
    public ResponseEntity<?> getAllCommunesByDistrictId(@PathVariable Integer id){
        List<Commune> communes = this.addressService.getAllCommunesByDistrictId(id);
        if(communes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communes, HttpStatus.OK);
    }
}
