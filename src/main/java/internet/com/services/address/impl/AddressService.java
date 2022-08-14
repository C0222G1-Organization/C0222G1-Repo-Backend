package internet.com.services.address.impl;

import internet.com.entity.customer.Commune;
import internet.com.entity.customer.District;
import internet.com.entity.customer.Province;
import internet.com.repository.address.ICommuneRepository;
import internet.com.repository.address.IDistrictRepository;
import internet.com.repository.address.IProvinceRepository;
import internet.com.services.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IProvinceRepository provinceRepository;
    @Autowired
    private IDistrictRepository districtRepository;
    @Autowired
    private ICommuneRepository communeRepository;

    @Override
    public List<Province> findAllProvince() {
        return provinceRepository.findAllProvince();
    }

    @Override
    public List<District> findAllDistrict(Integer provinceId) {
        return districtRepository.findAllDistrict(provinceId);
    }

    @Override
    public List<Commune> findAllCommune(Integer districtId) {
        return communeRepository.findAllCommune(districtId);
    }
}
