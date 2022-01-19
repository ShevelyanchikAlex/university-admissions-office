package com.epam.admissions.office.controller.listener;

import com.epam.admissions.office.dao.connection.ConnectionPool;
import com.epam.admissions.office.dao.connection.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    private final Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Application started working");
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            logger.error("Exception at initialize connection pool", e);
            throw new RuntimeException("Exception at initialize connection pool", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("Application finished working");
        ConnectionPool.getInstance().dispose();
    }
}
