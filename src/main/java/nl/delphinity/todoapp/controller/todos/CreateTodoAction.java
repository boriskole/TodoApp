package nl.delphinity.todoapp.controller.todos;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class CreateTodoAction implements SessionAware {

    private String description;
    private Map<String, Object> session;

    public String create() {

        Account account = (Account) session.get("account");

        account.addTodo(
                new Todo(description)
        );

        return "success";

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
