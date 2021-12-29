package exceptions;

public enum Exceptions {
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND"),
    METHOD_NOT_ALLOWED(404, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR");

    private final int code;
    private final String status;

    Exceptions(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode(){
        return code;
    }

    public String getStatus(){
        return status;
    }
}
