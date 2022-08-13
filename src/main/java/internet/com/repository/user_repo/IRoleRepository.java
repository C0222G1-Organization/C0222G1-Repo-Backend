package internet.com.repository.user_repo;

import internet.com.entity.user.AppRole;
import internet.com.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole, Integer> {
   /**
    * Create by HoangHN
    * Date create: 08/09/2022
    * function: findByName
    * @param name
    * @return
    */
   @Query(value = "SELECT id, name FROM role WHERE name = :name", nativeQuery = true)
   Optional<AppRole> findByName(UserRole name);

}
