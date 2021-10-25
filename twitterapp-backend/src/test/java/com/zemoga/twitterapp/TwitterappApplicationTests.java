package com.zemoga.twitterapp;

import com.zemoga.twitterapp.service.ServicePortfolio;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TwitterappApplicationTests {

	@Autowired
	ServicePortfolio servicePortfolio;

	public TwitterappApplicationTests() {
	}

	@Test
	public void contextLoads() {

	}

}
