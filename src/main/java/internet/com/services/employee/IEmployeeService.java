package internet.com.services.employee;

import internet.com.entity.employee.Employee;

public interface IEmployeeService {
    /**
     *Create by TrungND
     * Date create: 09/08/2022
     * function: save employee
     */
    void save(Employee employee);

    /**
     *Create by TrungND
     * Date create: 09/08/2022
     * function: Update employee
     */
    void update(Employee Employee);

    /**
     *Create by TrungND
     * Date create: 09/08/2022
     * function: findById employee
     */
    Employee findByIdEmployee(int id);
}
