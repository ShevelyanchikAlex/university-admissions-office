package com.epam.admissions.office.controller.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Application is starting.");
//        try {
//            ConnectionPool.getInstance().init();
//        } catch (ConnectionPoolException e) {
//            logger.error("Unable to initialize connection pool.", e);
//            throw new RuntimeException("Unable to initialize connection pool.", e);
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Application is shutting down.");
//        ConnectionPool.getInstance().dispose();
    }
}
