package com.arrelin.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class InventoryServiceApplicationTests {


	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldGetTrueOnCheckInStock() {
		var responseTrue =
				RestAssured.given()
				.queryParam("skuCode", "SAM1232128")
				.queryParam("quantity", 10)
				.get("/inventory")
				.then()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertTrue(responseTrue);

		var reposnseFalse =
				RestAssured.given()
				.queryParam("skuCode", "SAM1232128")
				.queryParam("quantity", 10000)
				.get("/inventory")
				.then()
				.statusCode(200)
				.extract().body().as(Boolean.class);
		assertFalse(reposnseFalse);
	}
}
