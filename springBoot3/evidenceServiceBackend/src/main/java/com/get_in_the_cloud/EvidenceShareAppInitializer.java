package com.get_in_the_cloud;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by davicres on 22/11/2016.
 */
public class EvidenceShareAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        ServletRegistration.Dynamic registration = container.addServlet("EvidenceShareService", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/EvidenceShareService/*");
    }

}
