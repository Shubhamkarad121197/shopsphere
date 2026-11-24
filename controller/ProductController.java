package com.shopsphere.shopsphere.controller;


import com.shopsphere.shopsphere.dto.ProductDTO;
import com.shopsphere.shopsphere.model.Product;
import com.shopsphere.shopsphere.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController  {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO){
        Product savedProduct=productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    Product updateProductById(@PathVariable Integer id,@Valid @RequestBody ProductDTO productDTO){
       return productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }



}
