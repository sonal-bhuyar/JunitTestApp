package com.product.service;

import com.product.dao.ProductDao;
import com.product.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class ProductServiceImpl implements  ProductService{

    ProductDao prodDao = null;

    public void ProductServiceImpl(){
        prodDao = new ProductDao();
    }

    public Map<String, Product> getProductsByType(String productType) {
       return prodDao.getProductsByType("Cards");
    }

    public double getProductPrice(String product) {
        return prodDao.getProductPrice("Santa");
    }
}
