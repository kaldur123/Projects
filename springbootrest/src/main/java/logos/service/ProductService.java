package logos.service;

import logos.entity.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    List<Product> findAll();

    void delete(Long id);
}
