package nl.delphinity.todoapp.repository.dao;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.interfaces.ITodoDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TodoDAO extends GenericDAO<Todo, Long> implements ITodoDAO {

    @Override
    public Set<Todo> findAllByAccount(Account account) {

        getSession().beginTransaction();

        List<Todo> result = getSession().createQuery("FROM Todo WHERE account = :account", Todo.class)
                .setParameter("account", account)
                .getResultList();

        getSession().getTransaction().commit();

        return new HashSet<>(result);

    }

}
