package com.spring;

import com.spring.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by NalinBakshi on 6/2/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestSpringApp {

    @Autowired
    private SpringApp springApp;


    @Test
    public void testPrintName(){
        springApp.getName();
        Assert.assertEquals("Hello", springApp.getName());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(5, springApp.getCount());
    }
}
