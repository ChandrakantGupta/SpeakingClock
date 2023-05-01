package com.clock.clockconverter;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClockConverterApplicationTests {
 
	    @Autowired
	    private WebTestClient webTestClient;

	    @Test
	    public void testGetHelloWorld() {
	        webTestClient.get()
	                .uri("/time-to-words?time=00:00")
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(String.class).isEqualTo("it's MidNight");
	    
	        webTestClient.get()
	                .uri("/time-to-words?time=12:00")
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(String.class).isEqualTo("it's Midday");	    
	      
	      webTestClient.get()
          .uri("/time-to-words?time=:00")
          .exchange()
          .expectStatus().isOk()
          .expectBody(String.class).isEqualTo("Invalid time format. Please enter time in HH:mm format.");
	    
	      webTestClient.get()
          .uri("/time-to-words?time=11:59")
          .exchange()
          .expectStatus().isOk()
          .expectBody(String.class).isEqualTo("it's eleven fifty nine minutes");
	 
	    
	      webTestClient.get()
          .uri("/time-to-words?time=27:60")
          .exchange()
          .expectStatus().isOk()
          .expectBody(String.class).isEqualTo("An error occurred while converting time to words.");
	 
	    }
	    

}
