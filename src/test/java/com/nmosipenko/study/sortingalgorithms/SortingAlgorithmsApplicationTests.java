package com.nmosipenko.study.sortingalgorithms;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SortingAlgorithmsApplicationTests {

	@Autowired
	private Controller controller;

	@Test
	void contextLoads() {
		Assert.assertNotNull(controller);
	}

}
