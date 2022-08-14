package internet.com.repository.employee_repo;


import internet.com.entity.employee.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    /**
     * Create by TrungND
     * Date create: 11/08/2022
     * function: create employee
     */
    @Modifying
    @Query(value = "insert into employee (employee_code, employee_name, address_id, date_of_birth," +
            " email, phone, position_id, start_work, image_url, salary, user_name, delete_status) " +
            "values (:employeeCode, :employeeName, :communeId, :dateOfBirth," +
            " :email, :phone, :positionId, :startWork, :imageUrl, :salary, :userName, 0)", nativeQuery = true)
    void saveEmployee(@Param("employeeCode") String employeeCode,
                      @Param("employeeName") String employeeName,
                      @Param("communeId") int communeId,
                      @Param("dateOfBirth") String dateOfBirth,
                      @Param("email") String email,
                      @Param("phone") String phone,
                      @Param("positionId") int positionId,
                      @Param("startWork") String startWork,
                      @Param("imageUrl") String imageUrl,
                      @Param("salary") int salary,
                      @Param("userName") String userName
    );

    /**
     * Create by TrungND
     * Date create: 11/08/2022
     * function: Update employee
     */
    @Modifying
    @Query(value = "update employee set employee_code=:employeeCode," +
            " employee_name=:employeeName," +
            " address_id=:addressId," +
            "date_of_birth=:dateOfBirth, " +
            "email=:email, phone=:phone," +
            " position_id=:positionId," +
            " start_work=:startWork," +
            " image_url=:imageUrl," +
            " salary=:salary," +
            "user_name =:userName " +
            " where id=:id", nativeQuery = true)
    void updateEmployee(@Param("employeeCode") String employeeCode,
                        @Param("employeeName") String employeeName,
                        @Param("addressId") int communeId,
                        @Param("dateOfBirth") String dateOfBirth,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("positionId") int positionId,
                        @Param("startWork") String startWork,
                        @Param("imageUrl") String imageUrl,
                        @Param("salary") int salary,
                        @Param("userName") String userName,
                        @Param("id") Integer id);

    /**
     * Create by TrungND
     * Date create: 11/08/2022
     * function: findById employee
     */
    @Query(value = "select id, employee_code, employee_name, \n" +
            "            address_id, date_of_birth, \n" +
            "             email, phone, position_id,\n" +
            "             start_work, image_url,\n" +
            "             salary, user_name,delete_status\n" +
            "             from employee where id =:id", nativeQuery = true)
    Employee findByIdEmployee(@Param("id") Integer id);
}
