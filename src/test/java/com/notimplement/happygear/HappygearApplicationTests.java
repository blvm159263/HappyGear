package com.notimplement.happygear;

import com.notimplement.happygear.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HappygearApplicationTests {

	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
//		assert  repository.findTop4ByQuantityOrOrderByQuantityAsc(80).size() > 0;
	}

}
