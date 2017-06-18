/*
* Copyright 2017, Julius Krah
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.juliuskrah.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Schedule {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Scheduled(cron = "${cron.time}", zone = "Africa/Accra")
	public void scheduledTask() {
		log.info("Scheduled job is starting...");

		log.info("Running query to determine total user records...");
		String sql = "SELECT COUNT(*) FROM users";
		int size = jdbcTemplate.queryForObject(sql, Integer.class);
		log.info("{} total user record(s) found", size);

		log.info("Running query to determine total inactive user records...");
		sql = "SELECT COUNT(*) FROM users u WHERE u.enabled = ?";		
		size = jdbcTemplate.queryForObject(sql, new Object[]{ false }, Integer.class);
		log.info("{} total inactive user record(s) found", size);

		log.info("Running query to delete inactive user records...");
		sql = "DELETE FROM users u WHERE u.enabled = ?";
		jdbcTemplate.update(sql, new Object[]{ false });
		sql = "SELECT COUNT(*) FROM users";
		size = jdbcTemplate.queryForObject(sql, Integer.class);
		log.info("{} total user record(s) found after deleting inactive users", size);
	}
}
