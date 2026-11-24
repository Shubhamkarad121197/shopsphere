package com.shopsphere.shopsphere.service;

import com.shopsphere.shopsphere.dto.ProductDTO;
import com.shopsphere.shopsphere.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDTO productDto);

    Product getProductById( Integer id);

    Product updateProduct(Integer id,ProductDTO productDTO);

    void deleteProduct(Integer id);
}
