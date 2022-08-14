package internet.com.services.record;

import internet.com.entity.record.Record;

public interface IRecordService {

    void createRecord(Integer customerId);

    void setEndTime(Integer id, String endTime);
}
