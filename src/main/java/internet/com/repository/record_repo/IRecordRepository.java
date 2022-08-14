package internet.com.repository.record_repo;


import internet.com.entity.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IRecordRepository extends JpaRepository<Record, Integer> {

    /**
     * Create by HoangHN
     * Date create: 13/08/2022
     * method create record
     * @param startTime
     * @param endTime
     * @param computerId
     * @param customerId
     */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO record (start_time, end_time, computer_id, customer_id) VALUE  " +
            "( :startTime, :endTime, :computerId, :customerId)", nativeQuery = true)
    void createRecord(@Param("startTime") String startTime,
                      @Param("endTime") String endTime,
                      @Param("computerId") Integer computerId,
                      @Param("customerId") Integer customerId);

    /**
     * Create by HoangHN
     * Date create: 13/08/2022
     * method set endTime when customer end service
     * @param id
     * @param endTime
     */
    @Modifying
    @Query(value = " UPDATE record SET end_time=:endTime WHERE id=:id", nativeQuery = true)
    void setEndTime(@Param("id") Integer id, @Param("endTime") String endTime);
}
