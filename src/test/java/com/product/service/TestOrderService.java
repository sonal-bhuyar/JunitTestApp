package com.product.service;

import com.product.model.Product;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class TestOrderService {

    private static OrdersServiceImpl ordersService = null;
    Map<String, Product> products = new HashMap<String, Product>();
    static Map<String, Product> cards = new HashMap<String, Product>();
    static Map<String, Product> artifacts = new HashMap<String, Product>();

   // ProductServiceImpl prodServ = null;


    @BeforeClass
    public static void loadData(){
        ordersService = new OrdersServiceImpl();
        ordersService.setProductService(new MockProductServiceImpl());

        cards = new HashMap<String, Product>();
        cards.put("birthday", new Product("birthday", "card", 5));
        cards.put("anniversary", new Product("anniversary", "card", 10));
        cards.put("valentines", new Product("valentines", "card", 15));
        cards.put("new years", new Product("new years", "card", 5.5));
        cards.put("Diwali", new Product("Diwali", "card", 7.5));

        artifacts = new HashMap<String, Product>();
        artifacts.put("Santa", new Product("Santa", "artifact", 15));
        artifacts.put("namePlate", new Product("namePlate", "artifact", 45));
        artifacts.put("doll", new Product("doll", "artifact", 25));
        artifacts.put("Bird", new Product("Bird", "artifact", 20));

    }


    @Test
    public void testSelectProducts(){
        ordersService.setProductService(new MockProductServiceImpl());
        products = ordersService.selectProduct("cards");
        Assert.assertEquals(4, products.size());

    }

    /*
    using mockito
     */
    @Test
    public void testMockitoSelectProducts(){
        //mockito
        ProductServiceImpl prodServ = mock(ProductServiceImpl.class);
        ordersService.setProductService(prodServ);
        when(prodServ.getProductsByType("cards")).thenReturn(cards);
        when(prodServ.getProductsByType("artifact")).thenReturn(artifacts);

        //test
        products = ordersService.selectProduct("cards");
        Assert.assertEquals(5, products.size());
        products = ordersService.selectProduct("artifact");
        Assert.assertEquals(4, products.size());

    }

    @Test
    public void testAddProductsToCart(){
        ordersService.setProductService(new MockProductServiceImpl());
        products = ordersService.selectProduct("artifact");
        Assert.assertEquals(4, products.size());

        ordersService.addProductToCart(products.get("santa"));
        Assert.assertEquals(1, ordersService.getCart().size());
        ordersService.addProductToCart(products.get("doll"));
        Assert.assertEquals(2, ordersService.getCart().size());

    }

    /*
    Mocking with mockito
     */
    @Test
    public void test_MockitoAddProductsToCart(){

        //mocking with  Mockito
        ProductServiceImpl prodServ = mock(ProductServiceImpl.class);
        ordersService.setProductService(prodServ);
        when(prodServ.getProductsByType("cards")).thenReturn(cards);
        when(prodServ.getProductsByType("artifact")).thenReturn(artifacts);
        ordersService.setCart(new ArrayList<Product>());
        //test
        products = ordersService.selectProduct("artifact");
        Assert.assertEquals(4, products.size());
        ordersService.addProductToCart(products.get("santa"));
        Assert.assertEquals(ordersService.getCart().size(), 1);
        ordersService.addProductToCart(products.get("doll"));
        Assert.assertEquals(ordersService.getCart().size(), 2);

    }


    @Test()
    public void testGetTotalPrice(){
        ordersService.setCart(populateCart());
        double totalPrice = ordersService.getTotalPrice();
        Assert.assertEquals(70, totalPrice, .5);

    }

    public List<Product> populateCart(){
        List<Product> cart = new ArrayList<Product>();
        cart.add( new Product("Santa", "artifact", 15));
        cart.add( new Product("namePlate", "artifact", 45));
        cart.add( new Product("anniversary", "card", 10));
        return  cart;
    }

}
