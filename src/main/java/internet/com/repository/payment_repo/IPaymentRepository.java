package internet.com.repository.payment_repo;

import internet.com.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
