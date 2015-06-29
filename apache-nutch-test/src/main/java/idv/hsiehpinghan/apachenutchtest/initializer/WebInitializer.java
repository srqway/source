package idv.hsiehpinghan.apachenutchtest.initializer;

import idv.hsiehpinghan.apachenutchtest.configuration.SpringConfiguration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setServletContext(servletContext);
		applicationContext.register(SpringConfiguration.class);
		addServlets(servletContext, applicationContext);
		addFilters(servletContext);
	}

	private void addServlets(ServletContext servletContext,
			AnnotationConfigWebApplicationContext applicationContext) {
		ServletRegistration.Dynamic dispatcherServlet = servletContext
				.addServlet("dispatcherServlet", new DispatcherServlet(
						applicationContext));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

	private void addFilters(ServletContext servletContext) {
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}

	// private void addListener(ServletContext servletContext,
	// AnnotationConfigWebApplicationContext applicationContext) {
	// servletContext.addListener(new
	// ContextLoaderListener(applicationContext));
	// }
}
