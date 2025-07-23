import java.util.*;

abstract class CourseType {
    private String name;
    public CourseType(String name) { this.name = name; }
    public String getCourseName() { return name; }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) { super(name); }
}

class Course<T extends CourseType> {
    private List<T> courseList;
    public Course(List<T> courseList) { this.courseList = courseList; }
    public List<T> getCourseList() { return courseList; }

    public static void printCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c.getCourseName());
        }
    }
}

public class UniversityCourses {
    public static void main(String[] args) {
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Math 101"));
        examCourses.add(new ExamCourse("Physics 101"));

        Course<ExamCourse> course = new Course<>(examCourses);
        Course.printCourses(course.getCourseList());
    }
}
