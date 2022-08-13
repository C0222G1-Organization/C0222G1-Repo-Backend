package internet.com.services.address.imp;

import internet.com.entity.customer.Commune;
import internet.com.entity.customer.District;
import internet.com.entity.customer.Province;
import internet.com.repository.address_repo.ICommuneRepo;
import internet.com.repository.address_repo.IDistrictRepo;
import internet.com.repository.address_repo.IProvinceRepo;
import internet.com.services.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private ICommuneRepo addressRepo;
    @Autowired
    private IDistrictRepo districtRepo;
    @Autowired
    private IProvinceRepo provinceRepo;

    @Override
    public List<Province> findAllProvince() {
        return provinceRepo.findAllProvince();
    }

    @Override
    public List<District> findAllDistrict(Integer provinceId) {
        return districtRepo.findAllDistrict(provinceId);
    }

    @Override
    public List<Commune> findAllCommune(Integer districtId) {
        return addressRepo.findAllCommune(districtId);
    }
}
