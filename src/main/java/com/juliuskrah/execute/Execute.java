package com.juliuskrah.execute;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Execute {
    @Autowired
    private JdbcTemplate jdbcTemplate;
   
    @Async
    public void insertBatch() {
        log.info("Starting bulk insert into users table asynchronously...");
        String sql = "INSERT INTO users VALUES(?, ?, ?)";
        StopWatch watch = new StopWatch();
        watch.start();

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
	        public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, String.format("user_%s", i));
                ps.setString(2, String.format("user123_%s", i));
                ps.setBoolean(3, i%3 == 0 ? false : true);
	        }

	        @Override
	        public int getBatchSize() {
		        return 1000000;
	        }
        });
        watch.stop();
        log.info("1000000 records inserted asynchronously in {} s", watch.getTotalTimeSeconds());
    }
}