package handler;


@SuppressWarnings("ALL")
class ServerRequest {

    //Defines the operation to be done on the DB
    private String operation;
    private Student student;


    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
