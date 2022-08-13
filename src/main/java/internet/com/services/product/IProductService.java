package internet.com.services.product;
import internet.com.entity.product.Product;
import internet.com.entity.product.product_dto.IProductDTO;
import internet.com.entity.product.product_dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<IProductDTO> findAll(String name, Pageable pageable);

    void delete(Integer id);

    void create(ProductDTO productDTO);

    Product findByIdProduct(int id);

    void updateProduct (String code,
                        String name,
                        Integer quantity,
                        String unit,
                        Integer prices,
                        String imageUrl,
                        Integer idProductCategory,
                        Integer id);

    void save(Product product);
}
