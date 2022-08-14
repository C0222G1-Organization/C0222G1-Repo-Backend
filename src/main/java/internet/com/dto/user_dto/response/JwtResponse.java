package internet.com.dto.user_dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Boolean errorStatus = true;
    private String message = "";
    private Object data;
    private String token;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse() {
    }

    public JwtResponse(Boolean errorStatus, String message) {
        this.errorStatus = errorStatus;
        this.message = message;
    }

    public JwtResponse(Boolean errorStatus, String message, Object data, String token, Collection<? extends GrantedAuthority> roles) {
        this.errorStatus = errorStatus;
        this.message = message;
        this.data = data;
        this.token = token;
        this.roles = roles;
    }

    public Boolean getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
