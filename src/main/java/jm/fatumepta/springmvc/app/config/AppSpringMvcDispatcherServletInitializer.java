package jm.fatumepta.springmvc.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppSpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // don't understand wtf is this!
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // contextConfigLocation (from applicationContext.xml)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // dispatcher servlet url-pattern (from applicationContext.xml)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
