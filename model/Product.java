package com.shopsphere.shopsphere.model;

import jakarta.persistence.*;


import java.math.BigDecimal;


@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false ,length=100)
    private String name;
    private String description;

    @Column(nullable = false,precision = 10,scale=2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stockQuantity;
    private String imageUrl;


    //Default Constructor
    public Product(){

    }

    //Paramaterized Constructor
    public Product(Integer id,String name,String description,BigDecimal price,Integer stockQuantity,String imageUrl){
       this.id=id;
       this.name=name;
       this.description=description;
       this.price=price;
       this.stockQuantity=stockQuantity;
       this.imageUrl=imageUrl;
    }

    //Getters
    public Integer getId(){
        return id;
    }
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
    public void setId(Integer id){
        this.id=id;
    }
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
