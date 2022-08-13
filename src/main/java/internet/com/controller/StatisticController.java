package internet.com.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistic")
@CrossOrigin(origins = "http://localhost:4200")
public class StatisticController {
    @Autowired
    private ModelMapper modelMapper;
}
