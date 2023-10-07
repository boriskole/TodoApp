package nl.delphinity.todoapp.repository.interfaces;

import nl.delphinity.todoapp.domain.Account;

import java.util.Optional;

public interface IAccountDAO extends IGenericDAO<Account, Long> {

    Optional<Account> findByEmail(String email);

}
