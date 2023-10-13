package nl.delphinity.todoapp.repository.dao;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.repository.interfaces.IAccountDAO;

import java.util.Optional;

public class AccountDAO extends GenericDAO<Account, Long> implements IAccountDAO {

    @Override
    public Optional<Account> findByEmail(String email) {
        getSession().beginTransaction();
        var result = getSession().createQuery("FROM Account WHERE email = :email", Account.class)
                .setParameter("email", email)
                .uniqueResultOptional();
        getSession().getTransaction().commit();
        return result;
    }

}
