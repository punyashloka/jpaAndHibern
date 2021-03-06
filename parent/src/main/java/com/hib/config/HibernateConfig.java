package com.hib.config;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hib.dto.User;

public class HibernateConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/local_poc");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				settings.put(Environment.SCANNER_DISCOVERY, "class, hbm");

				configuration.setProperties(settings);
				for (Class<?> cls : getEntityClassesFromPackage("com.hib.dto")) {
		            configuration.addAnnotatedClass(cls);
		        }
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public static List<Class<?>> getEntityClassesFromPackage(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
	    List<String> classNames = getClassNamesFromPackage(packageName);
	    List<Class<?>> classes = new ArrayList<Class<?>>();
	    for (String className : classNames) {
	        Class<?> cls = Class.forName(packageName + "." + className);
	        Annotation[] annotations = cls.getAnnotations();

	        for (Annotation annotation : annotations) {
	            System.out.println(cls.getCanonicalName() + ": " + annotation.toString());
	            if (annotation instanceof javax.persistence.Entity) {
	                classes.add(cls);
	            }
	        }
	    }

	    return classes;
	}
	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    ArrayList<String> names = new ArrayList<String>();

	    packageName = packageName.replace(".", "/");
	    URL packageURL = classLoader.getResource(packageName);

	    URI uri = new URI(packageURL.toString());
	    File folder = new File(uri.getPath());
	    File[] files = folder.listFiles();
	    for (File file: files) {
	        String name = file.getName();
	        name = name.substring(0, name.lastIndexOf('.'));  // remove ".class"
	        names.add(name);
	    }

	    return names;
	}
}