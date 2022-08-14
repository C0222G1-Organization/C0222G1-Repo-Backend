package internet.com.services.employee.impl;


import internet.com.entity.employee.Employee;
import internet.com.repository.employee_repo.IEmployeeRepository;
import internet.com.services.employee.IEmployeeService;
import internet.com.services.user.IRoleService;
import internet.com.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;


    /**
     *Create by TrungND
     * Date create: 10/08/2022
     * function: create employee
     */
    public void save(Employee employee) {
        userService.createUser(employee.getAppUser().getUsername(),employee.getAppUser().getPassword());
        roleService.addNewEmployeeUserRole(employee.getAppUser().getUsername());
        employeeRepository.saveEmployee(employee.getCode(),
                employee.getName(),
                employee.getCommune().getId(),
                employee.getDob(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getPosition().getId(),
                employee.getStartWork(),
                employee.getImage(),
                employee.getSalary(),
                employee.getAppUser().getUsername());
    }
    /**
     *Create by TrungND
     * Date create: 10/08/2022
     * function: update employee
     */
    @Override
    public void update(Employee Employee) {
        employeeRepository.updateEmployee(Employee.getCode(),
                Employee.getName(),
                Employee.getCommune().getId(),
                Employee.getDob(),
                Employee.getEmail(),
                Employee.getPhone(),
                Employee.getPosition().getId(),
                Employee.getStartWork(),
                Employee.getImage(),
                Employee.getSalary(),
                Employee.getAppUser().getUsername(),
                Employee.getId());
    }
    /**
     *Create by TrungND
     * Date create: 10/08/2022
     * function: findByID employee
     */
    @Override
    public Employee findByIdEmployee(int id) {
        return employeeRepository.findByIdEmployee(id);
    }

}
