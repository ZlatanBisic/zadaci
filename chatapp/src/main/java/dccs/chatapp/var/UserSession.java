package dccs.chatapp.var;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    public List<String> username;

    public UserSession() {
        username = new ArrayList();
    }
    
    public UserSession(String name) {
        username = new ArrayList();
        username.add(name);
    }

    public UserSession(List<String> username) {
        this.username = username;
    }

    public List<String> getUsername() {
        return username;
    }
}