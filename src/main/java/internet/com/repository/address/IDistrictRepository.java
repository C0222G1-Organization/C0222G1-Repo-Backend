package internet.com.repository.address;

import internet.com.entity.customer.District;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IDistrictRepository extends PagingAndSortingRepository<District, Integer> {
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value="select id, district_name, province_id from district where province_id = :provinceId", nativeQuery = true)
    List<District> findAllDistrict(@Param("provinceId") Integer provinceId);

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value = "SELECT dt.* FROM district dt JOIN province pr ON dt.province_id = pr.id WHERE dt.province_id =:id",
            countQuery = "SELECT dt.* FROM district dt JOIN province pr ON dt.province_id = pr.id WHERE dt.province_id =:id",nativeQuery = true)
    List<District> getDistrictByProvinceId(@Param("id") Integer id);
}
