package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.dto.ProductDTO;
import com.shopsphere.shopsphere.exception.ResourceNotFoundException;
import com.shopsphere.shopsphere.model.Product;
import com.shopsphere.shopsphere.repository.ProductRepository;
import com.shopsphere.shopsphere.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

   public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setImageUrl(productDTO.getImageUrl());

        return productRepository.save(product);

    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Product Not found with this id"+ id
                )
        );
    }

    @Override
    public Product updateProduct(Integer id, ProductDTO productDTO) {
        Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "Product Not Found With Id"+id
        ));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());

        return productRepository.save(product);
     }


     @Override
    public void deleteProduct(Integer id){
       Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
               "Product is not found with given Id"+id
       ));

       productRepository.delete(product);
    }

}
