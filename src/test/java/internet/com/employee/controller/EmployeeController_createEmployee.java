package internet.com.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import internet.com.dto.employee_dto.EmployeeDTO;
import internet.com.entity.customer.Commune;
import internet.com.entity.employee.Position;
import internet.com.entity.user.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_createEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Create employee successful
    @Test
    public void createEmployee_18() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP0001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(1);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(2);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // create employee item position and commune  null
    @Test
    public void createEmployee_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP0001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item code = ""
    @Test
    public void createEmployee_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item code not format
    @Test
    public void createEmployee_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("Em@@@93938");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item code minlenght
    @Test
    public void createEmployee_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("E");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item code maxlenght
    @Test
    public void createEmployee_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("Eeeeeemkkfkkfkfk");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item name maxlenght
    @Test
    public void createEmployee_name17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy TrungTrungTrungTrungTrungTrungTrungTrungTrungTrungTrungTrung");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item name minlenght
    @Test
    public void createEmployee_name16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("D");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item name not format
    @Test
    public void createEmployee_name15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("D@@@@gad,skww");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item name not format
    @Test
    public void createEmployee_name14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("");
        employeeDTO.setEmail("ndt807@gmail.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //create employee item Email =""
    @Test
    public void createEmployee_email14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item Email not format
    @Test
    public void createEmployee_email15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("112345432.com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item Email minlenght
    @Test
    public void createEmployee_email16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("a@Com");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item Email maxlenght
    @Test
    public void createEmployee_email17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.commmmmwijejwmmwmwijshudhhdhdh");
        employeeDTO.setPhone("0353585485");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item phone maxlenght
    @Test
    public void createEmployee_phone17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("035358548566666666");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item phone minlenght
    @Test
    public void createEmployee_phone16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0353");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item phone not format
    @Test
    public void createEmployee_phone15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("ândhh636284");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item phone = ""
    @Test
    public void createEmployee_phone14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("ândhh636284");
        employeeDTO.setDob("2001-07-18");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item dob = ""
    @Test
    public void createEmployee_dob14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item dob not format
    @Test
    public void createEmployee_dob15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("20000000");
        employeeDTO.setSalary("3000000");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item dob = ""
    @Test
    public void createEmployee_salary14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("2001-09-09");
        employeeDTO.setSalary("");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //create employee item dob not format
    @Test
    public void createEmployee_salary15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("2001-09-09");
        employeeDTO.setSalary("abdhdhasjd");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item dob minlenght
    @Test
    public void createEmployee_salary16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("2001-09-09");
        employeeDTO.setSalary("-1111");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("abcd.png");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //create employee item image = ""
    @Test
    public void createEmployee_image14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("2001-09-09");
        employeeDTO.setSalary("22888888");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //create employee item image not format
    @Test
    public void createEmployee_image15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setCode("EMP001");
        employeeDTO.setName("Duy Trung");
        employeeDTO.setEmail("Hahhaa@gmail.com");
        employeeDTO.setPhone("0235636284");
        employeeDTO.setDob("2001-09-09");
        employeeDTO.setSalary("22888888");
        employeeDTO.setStartWork("2022-08-16");
        employeeDTO.setImage("aggdhaja.com");
        AppUser appUser = new AppUser();
        appUser.setUsername("hieuhaha");
        appUser.setPassword("trung@123");
        employeeDTO.setAppUser(appUser);
        Position position = new Position();
        position.setId(0);
        employeeDTO.setPosition(position);
        Commune commune = new Commune();
        commune.setId(0);
        employeeDTO.setCommune(commune);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/employee/add")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}

