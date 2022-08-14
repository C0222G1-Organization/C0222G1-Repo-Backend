package internet.com.services.address;

import internet.com.entity.customer.Commune;
import internet.com.entity.customer.District;
import internet.com.entity.customer.Province;

import java.util.List;

public interface IAddressService {
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    List<Province> getAllProvinces();
    Province getProvinceById(Integer id);
    List<District> getAllDistricts();
    List<District> getDistrictsByProvinceId(Integer id);
    District getDistrictById(Integer id);
    List<Commune> getAllCommunes();
    List<Commune> getAllCommunesByDistrictId(Integer id);
    Commune getCommuneById(Integer id);
}
