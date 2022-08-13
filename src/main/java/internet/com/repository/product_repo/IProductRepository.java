package internet.com.repository.product_repo;

import internet.com.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
