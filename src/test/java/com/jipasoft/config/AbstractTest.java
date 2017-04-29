package com.jipasoft.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.jipasoft.Application;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Application.class })
public class AbstractTest {

	@Test
	public void configure() {

	}
}
