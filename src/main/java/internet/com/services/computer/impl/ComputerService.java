package internet.com.services.computer.impl;

import internet.com.dto.computer_dto.ComputerListDto;
import internet.com.entity.computer.Computer;
import internet.com.repository.computer_repo.IComputerRepository;
import internet.com.services.computer.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputerRepository computerRepository;

    /**
     * Created by: TuanHD
     * Date created: 09/08/2022
     * Function: findById
     */
    @Override
    public Computer findById(Integer id) {
        return computerRepository.findByIdComputer(id);
    }
    /**
     * Created by: TuanHD
     * Date created: 09/08/2022
     * Function: createComputer
     */
    @Override
    public void createComputer(Computer computer) {
        computerRepository.createComputer(computer.getCode(), computer.getConfiguration(), computer.getLocation(),
                computer.getManufacturer(), computer.getStartUsedDate(), computer.getStatus(), computer.getWarranty(), computer.getComputerType().getId()
                , computer.getDeleteStatus());
    }

    /**
     * Created by: TuanHD
     * Date created: 09/08/2022
     * Function: updateComputer
     */
    @Override
    public void updateComputer(Integer id, Computer computer) {
        computerRepository.updateComputer(computer.getCode(), computer.getConfiguration(), computer.getLocation(),
                computer.getManufacturer(), computer.getStartUsedDate(), computer.getStatus(), computer.getWarranty(), computer.getComputerType().getId()
                , computer.getDeleteStatus(), computer.getId());
    }

    /**
     * Created by: PhucNQ
     * Date created: 09/08/2022
     * Function: findAll
     */
    @Override
    public Page<ComputerListDto> findAll(Pageable pageable,
                                         String code,
                                         String location,
                                         String start,
                                         String end,
                                         String typeId,
                                         String status) {
        if (status.equals("")){
            return computerRepository.findAllEmpty(pageable, code, location, start, end, typeId, status);
        }else {
            return computerRepository.findAll(pageable, code, location, start, end, typeId, status);
        }
    }

    /**
     * Created by: PhucNQ
     * Date created: 09/08/2022
     * Function: delete
     */
    @Override
    public void delete(Integer id) {
        computerRepository.delete(id);
    }

}

