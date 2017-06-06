package com.product.service;

import com.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class OrdersServiceImpl implements OrdersService {
    ProductService productService = null;
    List<Product> cart = new ArrayList<Product>();

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public OrdersServiceImpl() {
        productService = new ProductServiceImpl();
        cart = new ArrayList<Product>();
    }

    public double getTotalPrice() {
        double price = 0;
        for(Product product : cart ){
            price += product.getPrice();
        }
        return price;
    }

    public List<Product> addProductToCart(Product product) {
        cart.add(product);
        return cart;
    }

    public Map<String, Product> selectProduct(String type) {
        Map<String, Product> products = productService.getProductsByType(type);
        return  products;
    }
}
