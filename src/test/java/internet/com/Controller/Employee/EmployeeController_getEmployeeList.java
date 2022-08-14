package internet.com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getEmployeeList {
    @Autowired
    private MockMvc mockMvc;



    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with size = 0
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_1_size0() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=h&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with size > 0
     * Return page list with totalPages = totalElements/2;
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_2_sizeBigger0() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code = null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_3_codeNull() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code = "" and everything is ok
     * Return page list with totalPages = totalElements/2;
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_4_codeEmpty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_5_codeNotExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=a&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is ok and everything is ok
     * Return a page list with the result is the employee list who has the code like what you typed
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_6_codeOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=e&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_7_nameNull() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=null&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name is "" and everything is ok
     * Return a page list with the result is the employee list
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_8_nameEmpty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_9_nameNotExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=y&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name is ok and everything is ok
     * Return an employee list who has name like what you typed
     */
    @Test
    public void getEmployeeList_10_nameOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=0000-00-00&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobFrom is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_11_dobFrom_Null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=null&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobFrom is "" and everything is ok
     * Return a page list with the employee list who has the date of birth until 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_12_dobFrom_Empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobFrom is not exist and everything is ok
     * Return a page list with the employee list who has the date of birth until 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_13_dobFrom_NotExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1212-11-11&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobFrom ok and everything is ok
     * Return a page list with the employee list who has the date of birth until 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_14_dobFrom_Ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=9999-12-31&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is null and everything is ok
     * Return a page list with the employee list who has the date of birth from 1212-11-11
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_15_dobEnd_Null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1212-11-11&dobend=null&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Create: LongNB
     * Date create: 10/08/2022
     *Get employee list with dobEnd is "" and everything is ok
     * Return a page list with the employee list who has the date of birth from 1212-11-11 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_16_dobEnd_Empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1212-11-11&dobend=&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobEnd is not exist in database and everything is ok
     * Return a page list with the employee list who has the date of birth from 1997-11-11 to 2051-02-02
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_17_dobEnd_NotExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2051-02-02&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobEnd is ok and everything is ok
     * Return a page list with the employee list who has the date of birth from 1997-11-11 to 2001-02-02
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_18_dobEnd_Ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=0000-00-00&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workF is null  and everything is ok
     * Return a page list with the employee list who starts work from 0000-00-00 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_19_workF_Null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=null&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workF is "" exist and everything is ok
     * Return a page list with the employee list who starts work from 0000-00-00 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_20_workF_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workFrom is not exist  and everything is ok
     * Return a page list with the employee list who starts work from 1515-12-12 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_21_workFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workF is ok  and everything is ok
     * Return a page list with the employee list who starts work from 2022-01-01 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_22_workF_ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=9999-12-31&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workT is null and everything is ok
     * Return a page list with the employee list who starts work from 2022-01-01 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_23_workT_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=null&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workTo is "" and everything is ok
     * Return a page list with the employee list who starts work from 2022-01-01 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_24_workTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workTo is not exist and everything is ok
     * Return a page list with the employee list who starts work from 2022-01-01 to 9999-12-31
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_25_workTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with workTo is ok and everything is ok
     * Return a page list with the employee list who starts work from 2022-01-01 to 2023-06-06
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_26_workTo_ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with pId is null and everything is ok
     * Return a page list with the employee list when pId = null
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_27_pId_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=null&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with pId is null and everything is ok
     * Return a page list with the employee list when pId is empty
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_28_pId_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with pId is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_29_pId_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=7&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with pId is ok and everything is ok
     * Return a page list with the employee list when pId is what you typed
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_30_pId_ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with address is null and everything is ok
     * Return a page list with the employee list when address null
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_31_address_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=null"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with address is empty and everything is ok
     * Return a page list with the employee list with all result
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_32_address_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with address is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_33_address_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=z"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with address is ok and everything is ok
     * Return a page list with the employee who has the address like what you search
     * Start from page 1 and total page = (total elements)/2
     */
    @Test
    public void getEmployeeList_34() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=h&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are null  and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_35_code_name_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are empty  and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_36_code_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are not exist in database  and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_37_code_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=4&name=z&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are ok  and everything is ok
     * Return a page list with the employee who has name and code like what you searched
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_38_code_name_ok() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=2&name=o&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is empty  and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_39_code_null_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_40_code_null_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=v&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is empty and name is null  and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_41_code_empty_name_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=null&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name is empty and code is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_42_name_empty_code_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=6&name=v&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is empty and name is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_43_code_empty_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=v&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and name is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_44_code_notExist_name_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=7&name=null&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and name is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_45_code_notExist_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=7&name=&dobfrom=1997-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobfrom are null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_46_code_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=null&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobFrom are "" in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_47_code_dobFrom_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobFrom are not exist in database in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_48_code_dobFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=t&name=&dobfrom=1111-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and dobFrom is "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_49_code_null_dobFrom_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and dobFrom is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_50_code_null_dobFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1111-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and dobFrom is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_51_code_empty_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=null&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and dobFrom is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_52_code_empty_dobFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1111-11-11&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist in database and dobFrom is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_53_code_notExist_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=6&name=&dobfrom=null&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist in database and dobFrom is "" and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_54_code_notExist_dobFrom_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=6&name=&dobfrom=&dobend=2001-02-02&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobend are null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_55_code_dobEnd_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=null&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobend are empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_56_code_dobEnd_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobTo are "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_57_code_dobTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobend are not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_58_code_dobTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and dobend is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_59_code_null_dobTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2222-12-22&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and dobend is "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_60_code_null_dobTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and dobTo is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_61_code_empty_dobTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=null&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and dobTo is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_62_code_empty_dobTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2666-11-11&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist in database and dobend is null and everything is ok
     * Return an empty at page 1
     */
    @Test
    public void getEmployeeList_63_code_notExist_dobEnd_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=y&name=&dobfrom=1997-12-11&dobend=null&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist in database and dobend is "" and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_64_code_notExist_dobEnd_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=y&name=&dobfrom=1997-12-11&dobend=&workf=2022-01-01&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workf are null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_65_code_workF_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=null&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workf are "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_66_code_workF_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workf are not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_67_code_workF_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=s&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=2222-12-12&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and workf is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_68_code_null_workF_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=2222-12-12&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and workf is "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_69_code_null_workF_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and workFrom is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_70_code_empty_workFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=null&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and workFrom is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_71_code_empty_workFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=1111-11-11&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and workFrom is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_72_code_notExist_workFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=y&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=null&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and workf is "" and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_73_code_notExist_workF_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=y&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=2023-06-06&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workT are null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_74_code_workTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=null&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workTo are "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_75_code_worKTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and workTo are not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_76_code_workTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=1234-12-12&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and workTo is not exist in database and everything is ok
     * Return a page list with the employee list who start work between ("workf" and "workt")
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_77_code_null_workTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=1234-11-11&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and workTo is "" and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_78_code_null_workTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and workTo is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_79_code_empty_workTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=null&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is "" and workTo is null and everything is ok
     * Return a page list with the employee list who start work between ("workf" and "workt")
     */
    @Test
    public void getEmployeeList_80_code_empty_workTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=1311-11-11&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and workTo is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_81_code_notExist_workTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=null&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is not exist and workTo is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_82_code_notExist_workTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=&dobfrom=1997-12-11&dobend=2022-12-12&workf=&workt=&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code  and name and dobFrom are empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_83_code_name_dobFrom_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code  and name and dobFrom are null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_84_code_name_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=null&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code  and name and dobFrom are not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_85_code_name_dobFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=v&dobfrom=1111-11-11&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is null and dobFrom is not exist in database and everything is ok
     * Return a page list with all result in database with the employee who start work between ("workf" and "workt")
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_86_code_name_null_dobFrom_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=1111-11-11&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is null and dobFrom is empty and everything is ok
     * Return a page list with all result in database with the employee who start work between ("workf" and "workt")
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_87_code_name_null_dobFrom_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is empty and dobFrom is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_88_code_null_name_empty_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=null&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is null and name is not exist in database and dobFrom is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_89_code_null_name_notExist_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=z&dobfrom=null&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is empty and name is not null and dobFrom is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_90_code_empty_name_null_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=null&dobfrom=null&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code is notExist and name is null and dobFrom is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_91_code_noExist_name_null_dobFrom_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=null&dobfrom=null&dobend=2022-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name and dobTo are null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_92_code_name_dobTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name and dobTo are empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_93_code_name_dobTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name and dobTo are not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_94_code_name_dobTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=z&dobfrom=1997-12-24&dobend=2222-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are null and dobTo is not exist in database and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_95_code_name_null_dobTo_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=1997-12-24&dobend=2222-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and name are null and dobTo is empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_96_code_name_null_dobTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=null&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobTo are null and name is empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_97_code_dobTo_null_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with code and dobTo are null and name is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_98_code_dobTo_null_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=z&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are null and code is not exist in database and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_99_name_dobTo_null_code_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=null&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are null and code is empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_100_name_dobTo_null_code_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=null&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are empty and code is null and everything is ok
     *
     */
    @Test
    public void getEmployeeList_101_name_dobTo_empty_code_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are empty and code is not exist in database and everything is ok
     * Retunr an empty list at page 1
     */
    @Test
    public void getEmployeeList_102_name_dobTo_empty_code_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are not exist in database and code is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_103_name_dobTo_notExist_code_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=z&dobfrom=1997-12-24&dobend=3333-11-11&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and dobTo are not exist in database and code is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_104_name_dobTo_notExist_code_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=null&name=v&dobfrom=1997-12-24&dobend=3333-11-11&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and code are not exist in database and dobTo is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_105_name_code_notExist_dobTo_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=n&name=v&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with name and code are not exist in database and dobTo is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_106_name_code_notExist_dobTo_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=n&name=v&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo and code are not exist in database and name is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_107_dobTo_code_notExist_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=n&name=&dobfrom=1997-12-24&dobend=4444-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo and code are not exist in database and name is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_108_dobTo_null_code_notExist_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=n&name=&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is not exist and code is null and name is empty and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_109_dobTo_notExist_code_null_name_empty() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=nulln&name=&dobfrom=1997-12-24&dobend=1111-11-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is empty and code are not exist in database and name is empty and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_110_dobTo_empty_code_null_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is empty and code is not exist in database and name is null and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_111_dobTo_empty_code_notExist_name_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=z&name=null&dobfrom=1997-12-24&dobend=&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is not exist and code is empty and name is null and everything is ok
     * Return a page list with all result in database
     * Start from page 1 and total page = (total elements)/2
     * Each page has 2 elements
     */
    @Test
    public void getEmployeeList_112_dobTo_notExist_code_empty_name_null() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=null&dobfrom=1997-12-24&dobend=5555-12-12&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     * Get employee list with dobTo is null and code is empty and name is not exist and everything is ok
     * Return an empty list at page 1
     */
    @Test
    public void getEmployeeList_113_dobTo_null_code_empty_name_notExist() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/0?code=&name=z&dobfrom=1997-12-24&dobend=null&workf=2022-02-02&workt=2023-04-05&pid=2&address=a"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    
}

