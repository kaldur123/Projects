package logos.mapper;

import logos.dto.ProductDto;
import logos.entity.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ProductDto convertToDto(Product product) {
        return new ModelMapper().map(product, ProductDto.class);
    }

    public static Product convertToProduct(ProductDto productDto) {
        return new ModelMapper().map(productDto, Product.class);
    }
}
