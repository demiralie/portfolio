package com.example.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMeshConfig {
	// SiteMesh
	@Bean
	FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<ConfigurableSiteMeshFilter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new ConfigurableSiteMeshFilter() {
			
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder.addDecoratorPath("/board/*", "/WEB-INF/decorators/board.jsp");
				builder.addDecoratorPath("/dept/*", "/WEB-INF/decorators/dept.jsp");
				builder.addDecoratorPath("/emp/*", "/WEB-INF/decorators/emp.jsp");
				builder.addDecoratorPath("/city/*", "/WEB-INF/decorators/city.jsp");
				builder.addDecoratorPath("/country/*", "/WEB-INF/decorators/country.jsp");
				builder.addDecoratorPath("/ontime/*", "/WEB-INF/decorators/ontime.jsp");
				builder.addDecoratorPath("/bootstrap/*", "/WEB-INF/decorators/bootstrap.jsp");
			}
		});

		filter.setUrlPatterns(Arrays.asList("/board/*", "/dept/*", "/emp/*", "/city/*", "/country/*", "/ontime/*", "/bootstrap/*" ));
		
		return filter;
	}

	@Bean
	FilterRegistrationBean<Filter> testFilter() {
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new Filter() {

			@Override
			public void init(FilterConfig filterConfig) throws ServletException {
				System.out.println("############################");
				System.out.println("### My Filter init() ###");
				System.out.println("############################");
			}

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chian)
					throws IOException, ServletException {
				System.out.println("#########################################");
				System.out.println("### My Filter doFilter() start... ###");
				System.out.println("#########################################");

				chian.doFilter(request, response);

				System.out.println("#######################################");
				System.out.println("### My Filter doFilter() end... ###");
				System.out.println("#######################################");
			}

			@Override
			public void destroy() {
				System.out.println("###############################");
				System.out.println("### My Filter dostory() ###");
				System.out.println("###############################");
			}
		});
		filter.setUrlPatterns(Arrays.asList("/dept/*", "/emp/*"));

		return filter;
	}
}
