package nl.delphinity.todoapp.controller.todos;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import org.apache.struts2.action.SessionAware;

import java.util.Map;
import java.util.Set;

public class TodosAction implements SessionAware {

    private Set<Todo> todos;
    private Account account;
    private String status;
    private Map<String, Object> session;

    public String todos() {

        account = (Account) session.get("account");

        todos = DAOFactory.getFactory()
                .getTodoDAO()
                .findAllByAccount(account);

        if (todos.isEmpty())
            status = "Looks like you're all caught up on your tasks.";
        else
            status = "You have " + todos.size() + " tasks left.";

        return "success";

    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
