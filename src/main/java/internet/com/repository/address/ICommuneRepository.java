package internet.com.repository.address;

import internet.com.entity.customer.Commune;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICommuneRepository extends PagingAndSortingRepository<Commune, Integer> {
    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value="select id, commune_name, district_id from commune where district_id = :districtId", nativeQuery = true)
    List<Commune> findAllCommune(@Param("districtId") Integer districtId);

    /**
     * Created by: CuongTM
     * Date Created: 11/08/2022
     * @return
     */
    @Query(value = "SELECT cm.* FROM commune cm JOIN district dt ON cm.district_id = dt.id WHERE cm.district_id =:id",
            countQuery = "SELECT cm.* FROM commune cm JOIN district dt ON cm.district_id = dt.id WHERE cm.district_id =:id",nativeQuery = true)
    List<Commune> getCommuneByDistrictId(@Param("id") Integer id);
}
