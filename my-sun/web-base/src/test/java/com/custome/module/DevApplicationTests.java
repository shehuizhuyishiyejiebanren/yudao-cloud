package com.custome.module;

import com.custome.module.company.htht.piemap.entity.ResultMapRouteInfor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(ResultMapRouteInfor.values());
	}

}
