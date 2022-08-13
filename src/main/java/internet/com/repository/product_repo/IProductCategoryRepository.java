package internet.com.repository.product_repo;

import internet.com.entity.product.ProductCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface IProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Integer> {

}
