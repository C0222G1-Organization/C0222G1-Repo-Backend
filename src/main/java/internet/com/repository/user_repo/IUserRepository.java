package internet.com.repository.user_repo;

import internet.com.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Integer> {

    /**
     * Create by HoangHN
     * Date create: 08/09/2022
     * function: findByUsername
     * @param name
     * @return
     */
    @Query(value = "SELECT user_name, user_password FROM user WHERE user_name = :name", nativeQuery = true)
    Optional<AppUser> findByUsername(String name);

}
