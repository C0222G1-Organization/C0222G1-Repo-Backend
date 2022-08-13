package internet.com.controller;

import internet.com.entity.customer.Commune;
import internet.com.entity.customer.District;
import internet.com.entity.customer.Province;
import internet.com.services.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping("/province")
    public ResponseEntity<?> findAllProvince(){
        List<Province> provinceList = this.addressService.findAllProvince();
        if(provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @GetMapping("/district/{id}")
    public ResponseEntity<?> findAllDistrict(@PathVariable("id") Integer id){
        List<District> districtList = this.addressService.findAllDistrict(id);
        if(districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping("/commune/{id}")
    public ResponseEntity<?> findAllCommune(@PathVariable("id") Integer id){
        List<Commune> communeList = this.addressService.findAllCommune(id);
        if(communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }
}
