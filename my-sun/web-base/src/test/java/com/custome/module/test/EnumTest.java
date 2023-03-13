package com.custome.module.test;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: EnumTest
 * @Author: sunlin
 * @Description:
 * @Date: 2022/10/28 17:26
 */
public class EnumTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test(){
        final ResultMapRouteInfor[] values = ResultMapRouteInfor.values();

        System.out.println(ResultMapRouteInfor.RouteInfors);
    }
}