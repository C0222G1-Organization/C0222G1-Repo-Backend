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
    List<Province> findAllProvince();
    List<District> findAllDistrict(Integer provinceId);
    List<Commune> findAllCommune(Integer districtId);
}
