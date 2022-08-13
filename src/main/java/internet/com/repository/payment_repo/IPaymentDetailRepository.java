package internet.com.repository.payment_repo;

import internet.com.entity.payment.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IPaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {

}
