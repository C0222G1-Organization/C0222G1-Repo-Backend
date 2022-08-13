package internet.com.services.computer;

import internet.com.entity.computer.ComputerType;

import java.util.List;

public interface IComputerTypeService {
    List<ComputerType> findAll();
}