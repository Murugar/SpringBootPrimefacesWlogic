package com.iqmsoft.wlogic.boot.jsf;

import org.primefaces.util.Constants;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.iqmsoft.wlogic.boot.jsf.jsf.FacesViewScope;

import javax.faces.application.ProjectStage;
import java.util.Collections;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(Collections.singletonMap("view", new FacesViewScope()));
    
        return configurer;
    }

    
    @Bean
    public ServletContextInitializer servletContextCustomizer() {
        return sc -> {
            sc.setInitParameter(Constants.ContextParams.THEME, "afternoon");
            sc.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
            sc.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
        };
    }

}
