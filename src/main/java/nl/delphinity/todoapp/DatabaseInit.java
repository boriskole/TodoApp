package nl.delphinity.todoapp;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.factories.DAOFactories;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import nl.delphinity.todoapp.repository.util.HibernateSessionManager;

public class DatabaseInit {

    public static void main(String ... args) {

        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();

        Account account = new Account("user@example.com", "user");

        Todo t1 = new Todo("Buy milk");
        Todo t2 = new Todo("Buy bread");
        Todo t3 = new Todo("Buy butter");

        DAOFactory.getFactory().getAccountDAO().save(account);

        account.addTodo(t1);
        account.addTodo(t2);
        account.addTodo(t3);

        HibernateSessionManager.close();

    }

}
