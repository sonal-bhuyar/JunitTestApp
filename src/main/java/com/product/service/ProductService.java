package com.product.service;

import com.product.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public interface ProductService {


    public Map<String, Product> getProductsByType(String productType);

    public double getProductPrice(String product);

}
