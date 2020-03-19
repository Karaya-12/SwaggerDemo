package com.swaggerdemo.domain;

import io.swagger.annotations.ApiModelProperty;

public class Product {

    @ApiModelProperty(name = "id", required = true, value = "1 2 3", notes = "Product Unique ID")
    private String id;
    @ApiModelProperty(name = "name", required = true, value = "AMD Ryzen", notes = "Product Name")
    private String name;
    @ApiModelProperty(name = "description", required = true, value = "Sample Description", notes = "Product Description")
    private String description;
    @ApiModelProperty(name = "price", required = true, value = "123.45", notes = "Product Price")
    private double price;
    @ApiModelProperty(name = "stock", required = true, value = "123", notes = "Product Stock")
    private long stock;

    public Product() {
    }

    public Product(String id, String name, String description, double price, long stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStock() {
        return this.stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock=" + stock + "]";
    }
}
