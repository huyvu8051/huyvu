package com.huyvu.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class Initializer implements WebApplicationInitializer {
	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("Không làm mà đòi có ăn thì chỉ có ăn đuồi bầu ăn shit");
    }
}