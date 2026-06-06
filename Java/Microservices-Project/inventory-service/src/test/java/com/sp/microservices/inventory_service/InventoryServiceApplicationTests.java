package com.sp.microservices.inventory_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer<?> mySQLContainer =
			new MySQLContainer<>("mysql:8.3.0");

	static {
		mySQLContainer.start();
	}

	@LocalServerPort
	private Integer port;

	@Test
	void shouldReadInventory() throws Exception {

		String url =
				"http://localhost:" + port +
						"/api/inventory?skuCode=iphone_15&quantity=100";

		HttpURLConnection connection =
				(HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();

		System.out.println("Response Code = " + responseCode);

		assertEquals(200, responseCode);
	}
}