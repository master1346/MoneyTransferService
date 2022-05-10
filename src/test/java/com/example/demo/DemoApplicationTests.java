package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private static final GenericContainer<?> myapp = new GenericContainer<>("myapp")
			.withExposedPorts(5501);

	@BeforeAll
	public static void setUp() {
		myapp.start();
	}

	@Test
	void contextLoads() {
		ResponseEntity<String> actual = testRestTemplate.getForEntity("http://localhost:" + myapp.getMappedPort(5501) + "/test", String.class);
		assertEquals("OK run test", actual.getBody());
	}

}
