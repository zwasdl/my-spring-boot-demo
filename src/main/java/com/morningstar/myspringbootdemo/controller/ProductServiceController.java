package com.morningstar.myspringbootdemo.controller;

import java.util.HashMap;
import java.util.Map;

import com.morningstar.myspringbootdemo.exception.ProductNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.morningstar.myspringbootdemo.model.Product;
import lombok.extern.slf4j.Slf4j;

import com.morningstar.myspringbootdemo.model.Product;
import com.morningstar.myspringbootdemo.service.ProductService;

@RestController
@Slf4j
public class ProductServiceController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts() {
        log.info("getProducts():{}", productService.getProducts());
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    @RequestMapping(value = "/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/product")
    public ResponseEntity<Object> getProductByName(
            @RequestParam(value = "name", required = false, defaultValue = "Honey") String name) {
        return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
    }
}