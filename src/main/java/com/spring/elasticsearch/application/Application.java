package com.spring.elasticsearch.application;

import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class Application {

	public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(Application.class, args);
        MDC.put("logFileName", "head1");
        log.debug("hello");
        MDC.remove("logFileName");
	}

}
