package com.product.service;

import com.product.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public interface OrdersService {

    public double getTotalPrice();

    public List<Product> addProductToCart(Product product);

    public Map<String, Product> selectProduct(String type);
}
