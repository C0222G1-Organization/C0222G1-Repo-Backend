package internet.com.dto.customer_dto;

import internet.com.entity.customer.Commune;
import internet.com.utils.CheckAge16Constraint;
import internet.com.utils.CheckEmailExitsConstraint;
import internet.com.utils.CheckPhoneExitsConstraint;
import internet.com.utils.CheckUserNameConstraint;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDTO {

    private Integer id;
    @Pattern(regexp = "^^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂ" +
            "ẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễ" +
            "ệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s?]+$", message = "Không được để trống tên hoặc có ký tự đặc biệt")
    private String name;

    @NotEmpty(message = "Không được để trống")
    @CheckAge16Constraint
    private String dateOfBirth;

    @CheckEmailExitsConstraint
    @Valid
    private EmailDTO email;

    @CheckPhoneExitsConstraint
    @Valid
    private PhoneDTO phoneNumber;

    @CheckUserNameConstraint
    @Valid
    private UserDTO userName;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Nhập sai định dạng")
    private String password;

    @NotNull(message = "Không được để trống")
    private Commune commune;

    public CustomerDTO() {
    }


    public CustomerDTO(Integer id,
                       String name,
                       String dateOfBirth,
                       EmailDTO email,
                       PhoneDTO phoneNumber,
                       UserDTO userName,
                       String password,
                       Commune commune) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.commune = commune;
    }

    public CustomerDTO(@Pattern(regexp = "^[a-zA-Z\\s?]+$", message = "Không được để trống tên hoặc có ký tự đặc biệt") String name, @NotEmpty(message = "Không được để trống") String dateOfBirth, @Valid EmailDTO email, @Valid PhoneDTO phoneNumber, @Valid UserDTO userName, @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Nhập sai định dạng") String password, @NotNull(message = "Không được để trống") Commune commune) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.commune = commune;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EmailDTO getEmail() {
        return email;
    }

    public void setEmail(EmailDTO email) {
        this.email = email;
    }

    public PhoneDTO getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneDTO phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserDTO getUserName() {
        return userName;
    }

    public void setUserName(UserDTO userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
}
