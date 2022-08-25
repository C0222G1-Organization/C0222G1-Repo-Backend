package internet.com.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import internet.com.dto.user_dto.request.SignInForm;
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
public class LoginController_login_signInForm {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login username = null >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("null");
        signInForm.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login password = null >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_password_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoangemp");
        signInForm.setPassword("null");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login username = "" >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("");
        signInForm.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login password = "" >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_password_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoangemp");
        signInForm.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login username = "&^*" >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_15() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoang*6$&");
        signInForm.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login username length < 6 >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("hoang");
        signInForm.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login password length < 6 >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_password_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoangemp");
        signInForm.setPassword("ahosz");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login username length > 40 >> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("hoahoanghoanghoanghoanghoanghoanghoanghoanghoanghoang" +
                "hoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoang" +
                "hoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoanghoangng");
        signInForm.setPassword("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login password length > 40>> 4xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_password_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoangemp");
        signInForm.setPassword("ahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahosz" +
                "ahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahosz" +
                "ahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahoszahosz");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: check login successfully >> 2xx
     * @throws Exception
     */
    @Test
    public void login_signInForm_18() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("nhathoangemp");
        signInForm.setPassword("Abc12345@");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}