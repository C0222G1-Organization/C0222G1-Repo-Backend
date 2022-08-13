package internet.com.repository.statistic;

import internet.com.entity.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StatisticRepository extends JpaRepository<Record, Integer> {

}
