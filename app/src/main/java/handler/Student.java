package handler;

public class Student {

    private String student_id;
    private String f_name;
    private String l_name;
    private String email;
    private String phone;
    private String natId;

    public Student(String f_name, String l_name, String email, String phone, String natId) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.phone = phone;
        this.natId = natId;
    }



    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }

    public String getStudent_id() {
        return student_id;
    }
}
