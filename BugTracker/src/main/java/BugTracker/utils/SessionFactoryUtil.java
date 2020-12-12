package BugTracker.utils;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.pojos.Employee;
import BugTracker.pojos.Post;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;

/**
 * Create a singleton instance of the sessionfactory to access the database.
 * 
 * @author Vincent
 *
 */

public class SessionFactoryUtil {

	private static SessionFactoryUtil sfu;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets up the Database with the required Username and Password,Connection Url,
	 * and hibernate settings
	 */
	private SessionFactoryUtil() {

		if (sessionFactory == null) {

			Map<String, String> settings = new HashMap<>();
			settings.put("hibernate.connection.url", System.getenv("DATABASE_URL"));
			settings.put("hibernate.connection.username", System.getenv("DATABASE_USERNAME"));
			settings.put("hibernate.connection.password", System.getenv("DATABASE_PASSWORD"));
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.connection.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.show_sql", "true");
			settings.put("hibernate.format_sql", "true");
			settings.put("hibernate.hbm2ddl.auto", "create");

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
					.build();

			Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Post.class).addAnnotatedClass(Ticket.class).addAnnotatedClass(Priority.class)
					.addAnnotatedClass(Status.class).addAnnotatedClass(UserRole.class).getMetadataBuilder().build();

			sessionFactory = metadata.getSessionFactoryBuilder().build();

		}
	}

	public static SessionFactoryUtil getSessionFactoryUtil() {
		if (sfu == null) {
			sfu = new SessionFactoryUtil();
		}

		return sfu;
	}
}
