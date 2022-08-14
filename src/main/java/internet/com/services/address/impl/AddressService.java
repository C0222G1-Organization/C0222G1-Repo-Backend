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
    public List<Province> getAllProvinces() {
        return provinceRepository.getAllProvinces();
    }
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public Province getProvinceById(Integer id) {
        return provinceRepository.getProvinceById(id);
    }
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public List<District> getAllDistricts() {
        return districtRepository.getAllDistricts();
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public List<District> getDistrictsByProvinceId(Integer id) {
        return districtRepository.getDistrictByProvinceId(id);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public District getDistrictById(Integer id) {
        return null;
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public List<Commune> getAllCommunes() {
        return communeRepository.getAllCommune();
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public List<Commune> getAllCommunesByDistrictId(Integer id) {
        return communeRepository.getCommuneByDistrictId(id);
    }

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Override
    public Commune getCommuneById(Integer id) {
        return null;
    }
}
