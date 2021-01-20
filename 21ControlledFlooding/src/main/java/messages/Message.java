package messages;

public class Message {
    int sequnceNumber;
    String message;

    public Message(String message, int sequnceNumber){
        this.message = message;
        this.sequnceNumber = sequnceNumber;
    }

    public String getMessage() {
        return message;
    }

    public int getSequnceNumber() {
        return sequnceNumber;
    }

    public void setSequnceNumber(int sequnceNumber) {
        this.sequnceNumber = sequnceNumber;
    }
}
