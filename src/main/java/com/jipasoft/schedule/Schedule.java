package com.jipasoft.schedule;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Schedule {

	@Scheduled(cron = "${cron.time}")
	public void message() {
		log.info("The current time is {}", LocalTime.now());
	}
}
