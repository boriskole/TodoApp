package nl.delphinity.todoapp.controller.todos;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import org.apache.struts2.action.SessionAware;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TodosAction implements SessionAware {

    private Account account;
    private String status;
    private Map<String, Object> session;
    private Set<Todo> todos;

    public String todos() {

        account = (Account) session.get("account");

        todos = DAOFactory.getFactory()
                .getTodoDAO()
                .findAllByAccount(account)
                .stream()
                .filter(todo -> !todo.getCompleted())
                .collect(Collectors.toSet());

        if (todos.isEmpty())
            status = "Looks like you're all caught up on your tasks.";
        else
            status = "You have " + todos.size() + " tasks left.";

        return "success";

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

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
