package nl.delphinity.todoapp.controller.account;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import org.apache.struts2.action.SessionAware;

import java.util.Map;
import java.util.Optional;

public class LoginAction implements SessionAware {

    private Map<String, Object> session;
    private String email;
    private String password;

    public String login() {

        if (email == null || password == null)
            return "error";

        Optional<Account> foundAccount = DAOFactory.getFactory()
                .getAccountDAO()
                .findByEmail(email);

        if (foundAccount.isEmpty())
            return "wrong";

        Account account = foundAccount.get();
        boolean passwordIsMatching = BCrypt.verifyer().verify(
                password.toCharArray(),
                account.getPassword()
        ).verified;

        if (passwordIsMatching) {
            session.put("account", account);
            return "success";
        }

        return "wrong";

    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
