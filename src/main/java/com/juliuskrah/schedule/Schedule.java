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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Schedule {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Scheduled(cron = "${cron.time}")
	public void message() {
		final String sql = "select count(*) from users u where u.enabled = :enabled";
		final Map<String, Boolean> paramMap = new HashMap<>();
		paramMap.put("enabled", false);
		
		final int size = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
		log.info("Result size {}", size);
	}
}
