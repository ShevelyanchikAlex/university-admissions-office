package com.epam.admissions.office.controller.listener;

import com.epam.admissions.office.dao.connection.ConnectionPool;
import com.epam.admissions.office.dao.connection.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ContextListener class.
 * Gets notified about ServletContext lifecycle changes.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ContextListener implements ServletContextListener {
    private final Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Application started working");
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException exception) {
            logger.error("Exception at initialize connection pool", exception);
            throw new RuntimeException("Exception at initialize connection pool", exception);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("Application finished working");
        ConnectionPool.getInstance().dispose();
    }
}
