package logos.controller.rest;

import logos.dto.ProductDto;
import logos.mapper.ProductMapper;
import logos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired private ProductService productService;

    @GetMapping("/hello")
    public String showHello() {
        return "Hello World";
    }

    @GetMapping("/products")
    public List<ProductDto> findAllProducts() {
        return productService.findAll().stream().map(p -> ProductMapper.convertToDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/products/{productId}")
    public ProductDto findProductById(@PathVariable("productId") Long id) {
        return ProductMapper.convertToDto(productService.findById(id));
    }

    @PostMapping("/products/add")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(ProductMapper.convertToProduct(productDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
