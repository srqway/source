package idv.hsiehpinghan.apachenutchtest.initializer;

import idv.hsiehpinghan.apachenutchtest.configuration.SpringConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setServletContext(servletContext);
		applicationContext.register(SpringConfiguration.class);
		addServlets(servletContext, applicationContext);
	}

	private void addServlets(ServletContext servletContext,
			AnnotationConfigWebApplicationContext applicationContext) {
		ServletRegistration.Dynamic dispatcherServlet = servletContext
				.addServlet("dispatcherServlet", new DispatcherServlet(
						applicationContext));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

	// private void addListener(ServletContext servletContext,
	// AnnotationConfigWebApplicationContext applicationContext) {
	// servletContext.addListener(new
	// ContextLoaderListener(applicationContext));
	// }
}
