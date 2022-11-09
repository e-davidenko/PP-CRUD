package com.excecc.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created in Intellij
 * User: Davidenko
 * Date: 07.11.2022
 * Time: 22:45
 */

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {return null;}

    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};}

    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        FilterRegistration.Dynamic encodingFilter = aServletContext.addFilter("encodingFilter", // ДЛЯ КИРИ́ЛЛИЦЫ
                new CharacterEncodingFilter());                                                    // ДЛЯ КИРИ́ЛЛИЦЫ
        encodingFilter.setInitParameter("encoding", "UTF-8");                               // ДЛЯ КИРИ́ЛЛИЦЫ
        encodingFilter.setInitParameter("forceEncoding", "true");                           // ДЛЯ КИРИ́ЛЛИЦЫ
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");             // ДЛЯ КИРИ́ЛЛИЦЫ
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }





}