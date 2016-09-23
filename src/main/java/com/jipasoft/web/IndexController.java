package com.jipasoft.web;

import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	private int i = 0;

	@GetMapping("/")
	public String index() {
		return "Next random is " + UUID.randomUUID();
	}

	@Scheduled(fixedRate = 5000)
	public void message() {
		System.out.printf("prints every 5000ms and increases by %d\n", i++);
	}
}
