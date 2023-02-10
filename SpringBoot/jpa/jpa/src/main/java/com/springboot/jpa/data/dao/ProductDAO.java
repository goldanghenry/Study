package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Product;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number, String name) throws Exception;
    Product deleteProduct(Long number) throws Exception;

}
