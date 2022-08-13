package internet.com.services.computer.impl;

import internet.com.entity.computer.ComputerType;
import internet.com.repository.computer_repo.IComputerTypeRepository;
import internet.com.services.computer.IComputerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerTypeService implements IComputerTypeService {
    @Autowired
    private IComputerTypeRepository iComputerTypeRepository;
    @Override
    public List<ComputerType> findAll() {
        return iComputerTypeRepository.findAllComputerType();
    }
}
