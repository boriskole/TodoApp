package nl.delphinity.todoapp.controller.account;

import at.favre.lib.crypto.bcrypt.BCrypt;
import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.repository.factories.DAOFactory;

import java.util.Optional;

public class RegisterAction {

    private String email;
    private String firstName;
    private String password;

    public String register() {

        if (email == null || firstName == null || password == null)
            return "error";

        Optional<Account> foundAccount = DAOFactory.getFactory()
                .getAccountDAO()
                .findByEmail(email);

        if (foundAccount.isPresent())
            return "taken";

        String hashedPassword = BCrypt.withDefaults().hashToString(
                12,
                password.toCharArray()
        );

        DAOFactory.getFactory()
                .getAccountDAO()
                .save(new Account(
                   email,
                   firstName,
                   hashedPassword
                ));

        return "success";

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
