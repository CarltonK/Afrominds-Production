package handler;

import java.util.List;


@SuppressWarnings("ALL")
class ServerResponse {
    private String result;
    private String message;
    private Student student;

    public String getMessage() {
        return message;
    }

    public Student getStudent() {
        return student;
    }

    public String getResult() {
        return result;
    }
}
