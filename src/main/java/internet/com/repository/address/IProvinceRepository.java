package internet.com.repository.address;


import internet.com.entity.customer.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Integer> {
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value = "SELECT id, province_name FROM province", nativeQuery = true)
    List<Province> getAllProvinces();

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value = "SELECT id, province_name FROM province WHERE id =:id", nativeQuery = true)
    Province getProvinceById(@Param("id") Integer id);
}
