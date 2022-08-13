package internet.com.entity.product.product_dto;

import internet.com.entity.product.ProductCategory;
import org.springframework.stereotype.Repository;

public interface IProductDTO {
    Integer getId();
    String getCode();
    String getNameProduct();
    Integer getQuantity();
    String getUnit();
    Integer getPrices();
    String getImageUrl();
    Integer getDeleteStatus();
    Integer getIdProductCategory();
    String getProductCategoryName();
}
