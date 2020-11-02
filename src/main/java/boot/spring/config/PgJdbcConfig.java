package boot.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@Component
public class PgJdbcConfig {
	
	@Bean(name="pgdruid")
	public DruidDataSource druidDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://172.16.3.155:5432/dw");
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		return ds;
	}
	
	@Bean(name="pgTemplate")
	public JdbcTemplate getjdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(druidDataSource());
		return jdbcTemplate;
	}
	
}
