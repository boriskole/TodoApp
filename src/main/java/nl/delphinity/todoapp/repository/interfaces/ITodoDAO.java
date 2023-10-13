package nl.delphinity.todoapp.repository.interfaces;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;

import java.util.Set;

public interface ITodoDAO extends IGenericDAO<Todo, Long> {

    Set<Todo> findAllByAccount(Account account);

}
