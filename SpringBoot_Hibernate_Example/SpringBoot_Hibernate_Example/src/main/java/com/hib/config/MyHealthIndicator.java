package com.hib.config;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.DataSourceHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Health health() {
		
		return check().up().build();
	}

	private Health check() {
		String query = "select 1";
		DataSource dataSource = SessionFactoryUtils.getDataSource(sessionFactory);
		DataSourceHealthIndicator ds = new DataSourceHealthIndicator(dataSource , query );
		return ds.health();
	}

}