package messages;

public class Response {
    String message;
    String code;
    public Response(String message, String code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode(){
        return code;
    }
}
