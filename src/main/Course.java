package main;

public class Course {
    private Integer courseID;
    private String courseName;
    private Integer year;
    private String semester;
    private String teacher;

    public Integer getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
