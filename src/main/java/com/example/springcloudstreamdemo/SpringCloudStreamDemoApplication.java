package com.example.springcloudstreamdemo;

import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudStreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamDemoApplication.class, args);
	}

	@Bean
	public Function<String, String> uppercaseSimple() {
		return value -> value.toUpperCase();
	}

//	@Bean
	public Function<KStream<Bytes, String>, KStream<Bytes, String>> uppercaseStream() {
		return input -> input
			.map((key, value) -> new KeyValue<>(null, value.toUpperCase()));
	}

}
