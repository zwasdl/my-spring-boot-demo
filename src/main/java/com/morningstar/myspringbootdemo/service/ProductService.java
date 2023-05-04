package com.morningstar.myspringbootdemo.service;

import java.util.Collection;
import com.morningstar.myspringbootdemo.model.Product;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
    public abstract Product getProductByName(String name);
    public abstract Product getProductById(String id);
}