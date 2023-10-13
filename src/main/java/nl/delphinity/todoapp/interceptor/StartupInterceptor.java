package nl.delphinity.todoapp.interceptor;

import nl.delphinity.todoapp.repository.factories.DAOFactories;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import nl.delphinity.todoapp.repository.util.HibernateSessionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupInterceptor implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateSessionManager.close();
    }

}
