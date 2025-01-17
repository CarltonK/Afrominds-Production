package handler;

public class SingleCourse {

    private String course_name;
    private String course_id;
    private String course_tutor;
    private String course_description;

    public SingleCourse(String course_name, String course_tutor, String course_description) {
        this.course_name = course_name;
        this.course_tutor = course_tutor;
        this.course_description = course_description;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_tutor() {
        return course_tutor;
    }

    public void setCourse_tutor(String course_tutor) {
        this.course_tutor = course_tutor;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}
