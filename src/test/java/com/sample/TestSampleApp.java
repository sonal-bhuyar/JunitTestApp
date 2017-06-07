package com.sample;

import org.junit.*;

import java.util.Date;

/**
 * Created by NalinBakshi on 6/2/2017.
 */
public class TestSampleApp {

    private static SampleApp app;
    @BeforeClass
    public static void setBeforeClass() {
        app = new SampleApp();
        System.out.println("before class.");
    }
    @Before
    public void setData(){
        System.out.println("setting data");
    }

    @Test
    public void printHelloTest(){
        System.out.println("testing print");
        String str = app.printHello();
        Assert.assertEquals(str, "Hello World");
        Assert.assertNotEquals(str, "Hi World");

    }

    @Test
    public void dateFormatTest(){

        System.out.println("testing date");
        String date = app.getTodaysDate();
        Assert.assertEquals(date, "06/06/2017");
        Assert.assertNotEquals(date, new Date());
    }

    @After
    public void removeData(){
        System.out.println("remove data");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }
}
