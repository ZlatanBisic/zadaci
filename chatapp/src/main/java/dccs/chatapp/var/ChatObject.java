package dccs.chatapp.var;

import java.util.ArrayList;
import java.util.List;

public class ChatObject {
    public List<Message> messages;
    public int nom;

    public ChatObject() {
        messages = new ArrayList();
        nom = 0;
    }

    public ChatObject(List<Message> messages, int nom) {
        this.messages = messages;
        this.nom = nom;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public int getNom() {
        return nom;
    }      
}