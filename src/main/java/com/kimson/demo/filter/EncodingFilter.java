package com.kimson.demo.filter;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@Configuration
public class EncodingFilter implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration filterRegistration = servletContext.addFilter("CharacterEncodingFilter",
				CharacterEncodingFilter.class);
		filterRegistration.setInitParameter("encoding", "utf-8");
		filterRegistration.setInitParameter("forceEncoding", "true");
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
	}

}