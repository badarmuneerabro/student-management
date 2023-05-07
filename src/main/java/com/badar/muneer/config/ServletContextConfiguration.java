package com.badar.muneer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.badar.muneer.formatter.PhoneNoFormatter;
import com.badar.muneer.formatter.RollNoFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.badar.muneer.controllers"})
public class ServletContextConfiguration implements WebMvcConfigurer
{

	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	public void addFormatters(FormatterRegistry registry) 
	{
		registry.addFormatter(new RollNoFormatter());
		registry.addFormatter(new PhoneNoFormatter());
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }
}
