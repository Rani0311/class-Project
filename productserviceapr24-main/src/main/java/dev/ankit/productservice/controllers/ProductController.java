package dev.ankit.productservice.controllers;

import dev.ankit.productservice.dtos.CategoryResponceDto;
import dev.ankit.productservice.dtos.CreateProductRequestDto;
import dev.ankit.productservice.dtos.ErrorDto;
import dev.ankit.productservice.dtos.FakeStoreProductDto;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.services.FakeStoreProductService;
import dev.ankit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto productRequestDto) {
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getImage(),
                productRequestDto.getCategory(),
                productRequestDto.getPrice()
        );
    }

    // ResponseEntity contains everything that a response requires:
    // Data, Status code and headers
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> responseData = productService.getAllProducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));

        return responseEntity;
    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getSingleProduct(id);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){

        return productService.deleteProduct(id);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody CreateProductRequestDto productRequestDto){
        return productService.updateProduct(id,
                productRequestDto.getTitle(),
                productRequestDto.getPrice(),
                productRequestDto.getDescription(),
                productRequestDto.getImage(),
                productRequestDto.getCategory());
    }
    @GetMapping("/products/categories")
    public List<CategoryResponceDto> getAllCategory(){
        return productService.getCategories();
    }
    @GetMapping("/products/category/{title}")
    public List<Product> getAllProductByCategory(@PathVariable("title") String title){
        return productService.GetProductByCategory(title);
    }


//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> handleNullPointerException() {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Something went wrong. Please try again");
//
//        return new ResponseEntity<>(errorDto,
//                        HttpStatusCode.valueOf(404));
//    }
}
