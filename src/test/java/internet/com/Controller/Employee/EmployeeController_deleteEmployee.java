package internet.com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_deleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     *Delete employee with id = 1
     * if id == null
     */
    @Test
    public void deleteEmployee_1() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/employee/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     *Delete employee with id = 1
     * if id == ""
     */
    @Test
    public void deleteEmployee_2() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/employee/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     *Delete employee with id = 1
     * if id is not exist in database
     */
    @Test
    public void deleteEmployee_3() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/employee/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create: LongNB
     * Date create: 10/08/2022
     *Delete employee with id = 1
     * if id is exist in database
     */
    @Test
    public void deleteEmployee_4() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/employee/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
