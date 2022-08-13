package internet.com.services.computer;

import internet.com.dto.computer_dto.ComputerListDto;
import internet.com.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IComputerService {

    Computer findById(Integer id);

    void createComputer(Computer computer);

    void updateComputer(Integer id,Computer computer);

    /**
     * Created by: PhucNQ
     * Date created: 09/08/2022
     * Function: findAll
     */
    Page<ComputerListDto> findAll(Pageable pageable,
                                  String code,
                                  String location,
                                  String start,
                                  String end,
                                  String typeId,
                                  String status);

    /**
     * Created by: PhucNQ
     * Date created: 09/08/2022
     * Function: findAll
     */
    void delete(Integer id);

}



