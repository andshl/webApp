package configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(DataAccessConfiguration.class);
        context.register(WebMVCConfiguration.class);
        context.register(SecurityConfiguration.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}