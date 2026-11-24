package com.shopsphere.shopsphere.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductDTO {

    @NotBlank(message="Product Name is Required")
    private String name;

    private  String description;

    @NotNull(message="Product Price is Required")
    @DecimalMin(value="0.01" ,message="Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message="Stock Quantitiy is required")
    @Min(value=0,message="Stock quantity should be greater than zero")
    private Integer stockQuantity;

    private String imageUrl;

    //Getters

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public Integer getStockQuantity(){
        return stockQuantity;
    }
    public String getImageUrl(){
        return imageUrl;
    }

    //Setters

    public void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
