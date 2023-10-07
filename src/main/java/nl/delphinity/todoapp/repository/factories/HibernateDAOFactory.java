package nl.delphinity.todoapp.repository.factories;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.dao.AccountDAO;
import nl.delphinity.todoapp.repository.dao.GenericDAO;
import nl.delphinity.todoapp.repository.dao.TodoDAO;
import nl.delphinity.todoapp.repository.interfaces.IAccountDAO;
import nl.delphinity.todoapp.repository.interfaces.ITodoDAO;
import nl.delphinity.todoapp.repository.util.HibernateSessionManager;
import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory {

    protected Session getCurrentSession() {
        return HibernateSessionManager.getSessionFactory().openSession();
    }

    @Override
    public IAccountDAO getAccountDAO() {
        GenericDAO<Account, Long> dao = null;
        try {
            dao = AccountDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IAccountDAO) dao;
    }

    @Override
    public ITodoDAO getTodoDAO() {
        GenericDAO<Todo, Long> dao = null;
        try {
            dao = TodoDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ITodoDAO) dao;
    }

}
