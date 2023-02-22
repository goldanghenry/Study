package com.springboot.advanced_jpa.data.dto;

public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto() {}
    public ProductResponseDto(Long number, String name, int price, int stock){
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
//         1. 생성자로 초기화

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
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

//    2. Builder 패턴으로 초기화 -> 생성시 필요한 데이터만 설정 가능(null 명시x)
//    public static ProductResponseDtoBuilder builder() {
//        return new ProductResponseDtoBuilder();
//    }
//
//    public static class ProductResponseDtoBuilder {
//        private Long number;
//        private String name;
//        private int price;
//        private int stock;
//
//        ProductResponseDtoBuilder(){}
//        public ProductResponseDtoBuilder number(Long number){
//            this.number = number;
//            return this;
//        }
//        public ProductResponseDtoBuilder name(String name){
//            this.name = name;
//            return this;
//        }
//        public ProductResponseDtoBuilder price(int price){
//            this.price = price;
//            return this;
//        }
//        public ProductResponseDtoBuilder stock(int stock){
//            this.stock = stock;
//            return this;
//        }
//        public ProductResponseDto build(){
//            return new ProductResponseDto(number, name, price, stock);
//        }
//        public String toString(){
//            return "ProductResponseDto.ProductResponseDtoBuilder(number="+ this.number +", name="+ this.name
//                    +", price=" + this.price + ", stock="+this.stock +")";
//        }
}


