package com.custome.module;

import com.custome.module.company.htht.piemap.entity.ResultMapRouteInfor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: SomeTestTest
 * @Author: sunlin
 * @Description:
 * @Date: 2022/10/28 17:26
 */
public class SomeTestTest {

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