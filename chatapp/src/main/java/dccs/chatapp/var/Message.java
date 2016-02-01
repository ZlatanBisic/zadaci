package dccs.chatapp.var;

public class Message {
    public String name, message;
    public int length;

    public Message() {
    }

    public Message(String name, String message) {
        this.name = name;
        this.message = message;
        this.length = message.length();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
    
    public int getLength() {
        return length;
    }
}