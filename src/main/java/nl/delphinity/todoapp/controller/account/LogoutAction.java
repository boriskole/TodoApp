package nl.delphinity.todoapp.controller.account;

import nl.delphinity.todoapp.repository.util.HibernateSessionManager;
import org.apache.struts2.action.SessionAware;

import java.util.Map;

public class LogoutAction implements SessionAware {

    private Map<String, Object> session;

    public String logout() {
        session.clear();
        HibernateSessionManager.getSessionFactory().getCurrentSession().close();
        return "success";
    }

    @Override
    public void withSession(Map<String, Object> session) {
        this.session = session;
    }

}
