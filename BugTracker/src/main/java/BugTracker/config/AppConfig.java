package BugTracker.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import BugTracker.utils.SessionFactoryUtil;

@Configuration
@ComponentScan(value = "BugTracker")
@EnableAspectJAutoProxy
@EnableWebMvc
public class AppConfig implements WebApplicationInitializer {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatchContext = new AnnotationConfigWebApplicationContext();

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(dispatchContext));

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	@Bean
	public SessionFactory sessFactory() {
		return SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	}

}
