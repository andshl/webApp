package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("project")
public class WebMVCConfiguration {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolverlver = new InternalResourceViewResolver();
        resourceViewResolverlver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resourceViewResolverlver.setPrefix("/WEB-INF/");
        resourceViewResolverlver.setSuffix(".jsp");

        return resourceViewResolverlver;
    }
}
