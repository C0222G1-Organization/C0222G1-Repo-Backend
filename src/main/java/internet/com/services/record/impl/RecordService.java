package internet.com.services.record.impl;

import internet.com.dto.user_dto.response.JWTResponseCustomer;
import internet.com.entity.computer.Computer;
import internet.com.entity.record.Record;
import internet.com.repository.computer_repo.IComputerRepository;
import internet.com.repository.record_repo.IRecordRepository;
import internet.com.services.computer.IComputerService;
import internet.com.services.customer.ICustomerService;
import internet.com.services.record.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class RecordService implements IRecordService {

    private String startTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());
    Integer remainingTime = 0;
    @Autowired
    IRecordRepository iRecordRepository;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IComputerService iComputerService;
    @Autowired
    IComputerRepository iComputerRepository;

    public static void main(String[] args) throws ParseException {
//        String timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());
//        System.out.println(timeStamp);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        String dateInString = "7-Jun-2013";
//        Date date = formatter.parse(dateInString);
//        System.out.println(date.getMonth());
        Calendar DateTime = Calendar.getInstance();
        DateTime.add(Calendar.SECOND, 86400);
        String endTimeOfCustomer = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(DateTime.getTime());
        System.out.println(endTimeOfCustomer);
    }

    @Override
    public JWTResponseCustomer createRecord(Integer customerId) {
        remainingTime = iCustomerService.getRemainingTime(customerId);

        Calendar dateTime = Calendar.getInstance();
        dateTime.add(Calendar.SECOND, remainingTime);
        String endTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(dateTime.getTime());
        System.out.println(endTime);

        List<Computer> computerList = iComputerService.findUnusedComputer();
        Integer computerId = computerList.get(0).getId();
        iComputerService.setActiveStatus(computerList.get(0).getId(),0);

        iRecordRepository.createRecord(startTime,endTime,
                computerId, customerId);
        JWTResponseCustomer jwtResponseCustomer = new JWTResponseCustomer();
        jwtResponseCustomer.setComputerInUse(computerList.get(0).getId());
        jwtResponseCustomer.setMessage("Đăng nhập thành công");
        jwtResponseCustomer.setStartTime(startTime);
        jwtResponseCustomer.setEndTime(endTime);
        return jwtResponseCustomer;

    }

    @Override
    public void setEndTime(Integer id, String endTime) {
        iRecordRepository.setEndTime(id,endTime);
    }
}
