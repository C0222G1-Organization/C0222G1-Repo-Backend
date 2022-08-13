package internet.com.repository.user_repo;

import internet.com.entity.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IRoleRepository extends JpaRepository<AppRole, Integer> {

}
