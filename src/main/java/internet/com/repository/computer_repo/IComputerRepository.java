package internet.com.repository.computer_repo;

import internet.com.dto.computer_dto.ComputerListDto;
import internet.com.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IComputerRepository extends JpaRepository<Computer, Integer> {

    /**
     * Created by: TuanHD
     * Date created: 09/08/2022
     * Function: createComputer
     */
    @Modifying
    @Query(value = "insert into computer (computer_code,configuration,location,manufacturer,start_used_date,active_status" +
            ",warranty,type_id,delete_status) values (:code,:configuration,:location,:manufacturer,:start_used_date," +
            ":active_status,:warranty,:type_id,:delete_status)", nativeQuery = true)
    void createComputer(@Param("code") String code, @Param("configuration") String configuration, @Param("location") String location,
                        @Param("manufacturer") String manufacturer, @Param("start_used_date") String start_used_date,
                        @Param("active_status") Integer activeStatus, @Param("warranty") String warranty,
                        @Param("type_id") Integer typeId, @Param("delete_status") Integer deleteStatus);

    /**
     * Created by: TuanHD
     * Date created: 09/08/2022
     * Function: updateComputer
     */
    @Modifying
    @Query(value = "update computer set computer_code=:code,configuration=:configuration,location=:location," +
            "manufacturer=:manufacturer,start_used_date=:start_used_date,active_status =:active_status," +
            " warranty=:warranty,type_id=:type_id,delete_status=:delete_status where id=:id", nativeQuery = true)
    void updateComputer(@Param("code") String code, @Param("configuration") String configuration, @Param("location") String location,
                        @Param("manufacturer") String manufacturer, @Param("start_used_date") String start_used_date,
                        @Param("active_status") Integer activeStatus, @Param("warranty") String warranty,
                        @Param("type_id") Integer typeId, @Param("delete_status") Integer deleteStatus, @Param("id") Integer id);

    /**
     * Created by: PhucNQ
     * Date created: 10/08/2022
     * Function: findAll
     */
    @Query(value = "select id, delete_status as `delete`, computer_code as code, location, configuration, active_status as status, type_id as type, warranty, manufacturer, start_used_date as start " +
            "from computer " +
            "where computer_code like %:code% " +
            "and location like %:location% " +
            "and (start_used_date between :start and :end) " +
            "and type_id like %:typeId% " +
            "and active_status like %:status% " +
            "and delete_status = 0",
            nativeQuery = true,
            countQuery = "select count(*) " +
                    "            from computer " +
                    "            where computer_code like %:code% " +
                    "            and location like %:location% " +
                    "            and (start_used_date between :start and :end) " +
                    "            and type_id like %:typeId% " +
                    "            and active_status like %:status%" +
                    "            and delete_status = 0")
    Page<ComputerListDto> findAll(Pageable pageable, @Param("code") String code,
                                  @Param("location") String location,
                                  @Param("start") String start,
                                  @Param("end") String end,
                                  @Param("typeId") String typeId,
                                  @Param("status") String status);

    /**
     * Created by: PhucNQ
     * Date created: 10/08/2022
     * Function: delete
     */
    @Modifying
    @Query(value = "update computer set delete_status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value="select * from computer where id=:id",nativeQuery = true)
    Computer findByIdComputer(@Param("id") Integer id);
}
