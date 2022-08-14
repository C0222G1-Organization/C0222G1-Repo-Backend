package internet.com.dto.customer_dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
    private Integer id;

    @NotEmpty(message = "Không được để trống")
    private String username;

    public UserDTO() {
    }

    public UserDTO(Integer id, @NotEmpty(message = "Không được để trống") String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
