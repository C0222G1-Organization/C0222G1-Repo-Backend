package internet.com.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecordController {
    @Autowired
    private ModelMapper modelMapper;
}
