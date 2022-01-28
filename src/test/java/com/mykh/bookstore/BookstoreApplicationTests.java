package com.mykh.bookstore;

import com.mykh.bookstore.helper.ApplicationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private ApplicationInfo applicationInfo;

	@Test
	void contextLoads() {
		applicationInfo.yamlConfigurationInfo();
	}

}
