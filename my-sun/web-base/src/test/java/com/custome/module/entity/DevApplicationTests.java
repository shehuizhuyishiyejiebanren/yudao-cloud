package com.custome.module.entity;

import com.custome.module.test.ResultMapRouteInfor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(ResultMapRouteInfor.values());
	}

}
