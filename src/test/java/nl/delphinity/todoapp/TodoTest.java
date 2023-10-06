package nl.delphinity.todoapp;

import nl.delphinity.todoapp.domain.Account;
import nl.delphinity.todoapp.domain.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    public void addTodoTest() {

        Account a = new Account("user@example.com", "user");
        Todo t = new Todo("Buy milk");

        a.addTodo(t);

        assertTrue(a.getTodos().contains(t));

    }

}
