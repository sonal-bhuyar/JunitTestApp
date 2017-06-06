package com.product.service;

import com.product.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class MockProductServiceImpl implements ProductService{

    Map<String, Product> products = null;

    public Map<String, Product> getProductsByType(String productType) {
        products = new HashMap<String, Product>();
        if(productType.equalsIgnoreCase("cards")){
            products.put("birthday", new Product("birthday", "card", 5));
            products.put("anniversary", new Product("anniversary", "card", 10));
            products.put("valentines", new Product("valentines", "card", 15));
            products.put("new years", new Product("new years", "card", 5.5));

        }
        else if(productType.equalsIgnoreCase("artifact")){
            products.put("Santa", new Product("Santa", "artifact", 15));
            products.put("namePlate", new Product("namePlate", "artifact", 45));
            products.put("doll", new Product("doll", "artifact", 25));
            products.put("Bird", new Product("Bird", "artifact", 20));

        }
        return products;
    }

    public double getProductPrice(String product) {
        return 0;
    }
}
