package internet.com.repository.user_repo;

import internet.com.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<AppUser, Integer> {

}
