package com.jipasoft.web;

import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "Next random is " + UUID.randomUUID();
	}

	@Scheduled(fixedRate = 1000)
	public void message() {
		System.out.println("prints every 1000ms");
	}
}
