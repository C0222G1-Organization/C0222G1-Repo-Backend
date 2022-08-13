package internet.com.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
