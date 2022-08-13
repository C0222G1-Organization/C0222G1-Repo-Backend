package internet.com.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class AppUser {
    @Id
    @Column(name = "user_name")
    private String userName;
}
