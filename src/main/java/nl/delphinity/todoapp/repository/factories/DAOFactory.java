package nl.delphinity.todoapp.repository.factories;

import nl.delphinity.todoapp.repository.interfaces.IAccountDAO;
import nl.delphinity.todoapp.repository.interfaces.ITodoDAO;

public abstract class DAOFactory {

    private static DAOFactory factory;

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(Class<? extends DAOFactory> factory) {
        try {
            DAOFactory.factory = factory.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create DAOFactory: " + factory);
        }
    }

    public abstract IAccountDAO getAccountDAO();
    public abstract ITodoDAO getTodoDAO();

}
