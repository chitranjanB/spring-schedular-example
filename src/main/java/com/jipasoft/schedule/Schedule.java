package com.jipasoft.schedule;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	@Scheduled(cron = "${cron.time}")
	public void message() {
		System.out.printf("The current time is %s\n", LocalTime.now());
	}
}
