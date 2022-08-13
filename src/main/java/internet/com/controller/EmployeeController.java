package internet.com.controller;

import internet.com.dto.employee_dto.EmployeeDTO;
import internet.com.entity.employee.Employee;
import internet.com.entity.user.AppUser;
import internet.com.services.employee.IEmployeeService;
import internet.com.services.user.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService iUserService;

    /**
     * Create by : TrungND
     * Date created: 09/08/2022
     * function: Add employee
     */
    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    /**
     * Create by : TrungND
     * Date created: 09/08/2022
     * function: find by id employee
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
        Employee employee = employeeService.findByIdEmployee(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Create by : TrungND
     * Date created: 09/08/2022
     * function: Update Employee by Id
     */
    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employeeObj = modelMapper.map(employeeDTO, Employee.class);
            employeeService.update(employeeObj);
            AppUser appUser = iUserService.findByUsername(employeeDTO.getAppUser().getUsername()).get();
            appUser.setPassword(employeeDTO.getPassword());
            iUserService.updateUser(appUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
