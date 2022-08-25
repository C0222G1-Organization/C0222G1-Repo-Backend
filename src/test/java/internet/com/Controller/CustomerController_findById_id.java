package internet.com.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CustomerController_findById_id {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check id = null >> 4xx
     * @throws Exception
     */
    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check id = "" >> 4xx
     * @throws Exception
     */
    @Test
    public void findById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check id not found >> 4xx
     * @throws Exception
     */
    @Test
    public void findById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/98989898"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: find by id successfully >> 2xx
     * @throws Exception
     */
    @Test
    public void findById_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}