package nl.delphinity.todoapp.controller.todos;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import nl.delphinity.todoapp.repository.factories.DAOFactory;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class CompleteTodoAction implements SessionAware {

    private Map<String, Object> session;
    private Long id;

    public String complete() {

        Account account = (Account) session.get("account");
        Todo todo = DAOFactory.getFactory()
                .getTodoDAO()
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("Todo does not exist")
                );

        todo.setCompleted(true);

        DAOFactory.getFactory()
                .getTodoDAO()
                .merge(todo);

        return "success";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
