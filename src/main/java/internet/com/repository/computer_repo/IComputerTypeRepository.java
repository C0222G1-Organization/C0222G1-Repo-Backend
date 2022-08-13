package internet.com.repository.computer_repo;

import internet.com.entity.computer.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IComputerTypeRepository extends JpaRepository<Computer, Integer> {

}
