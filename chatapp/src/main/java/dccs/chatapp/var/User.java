package dccs.chatapp.var;

public class User {
    public String user;

    public User() {
    }

    public User(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    
    @Override
    public String toString() {
        return user;
    }
    
}