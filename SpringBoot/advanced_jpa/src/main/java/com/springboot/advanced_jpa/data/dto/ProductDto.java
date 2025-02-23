package com.springboot.advanced_jpa.data.dto;

public class ProductDto {
    private String name;
    private int price;
    private int stock;  // 재고

    public ProductDto(String name, int price, int stock){   // 생성자
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
