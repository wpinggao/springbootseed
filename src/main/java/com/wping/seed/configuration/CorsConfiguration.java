package com.wping.seed.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new com.thetransactioncompany.cors.CORSFilter());
        filterRegistration.addInitParameter("cors.allowOrigin", "*");
        filterRegistration.addInitParameter("cors.supportedMethods", "GET, POST, HEAD, PUT, DELETE");
        filterRegistration.addInitParameter("cors.supportedHeaders", "*");
        filterRegistration.addInitParameter("cors.supportsCredentials", "true");
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(-1);
        return filterRegistration;
    }

}
