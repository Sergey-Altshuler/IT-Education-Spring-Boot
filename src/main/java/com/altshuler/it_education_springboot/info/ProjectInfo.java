package com.altshuler.it_education_springboot.info;

import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.model.Student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectInfo {

    private static boolean AdminInitialized = false;
    private static Student currentStudent = null;
    private static Coach currentCoach = null;
    private static Course currentCourse = null;
    private static Map<Course, Map<Student, Map<String, String>>> marks = new LinkedHashMap<>();
    private static final Map<String, String> roles = new HashMap<>();
    private static Integer numOfCurrentCourse = null;

    static {
        roles.put("admin", "adminValidate");
        roles.put("student", "studentValidate");
        roles.put("coach", "coachValidate");
    }

    public static Integer getNumOfCurrentCourse() {
        return numOfCurrentCourse;
    }

    public static void setNumOfCurrentCourse(Integer numOfCurrentCourse) {
        ProjectInfo.numOfCurrentCourse = numOfCurrentCourse;
    }

    public static boolean IsAdminInitialized() {
        return AdminInitialized;
    }

    public static void setAdminInitialized(boolean isAdminInitialized) {
        ProjectInfo.AdminInitialized = isAdminInitialized;
    }

    public static Map<String, String> getRoles() {
        return roles;
    }

    public static Course getCourse() {
        return currentCourse;
    }

    public static void setCourse(Course course) {
        ProjectInfo.currentCourse = course;
    }

    public static Map<Course, Map<Student, Map<String, String>>> getMarks() {
        return marks;
    }

    public static void setMarks(Map<Course, Map<Student, Map<String, String>>> marks) {
        ProjectInfo.marks = marks;
    }

    public static Student getStudent() {
        return currentStudent;
    }

    public static void setStudent(Student student) {
        ProjectInfo.currentStudent = student;
    }

    public static Coach getCoach() {
        return currentCoach;
    }

    public static void setCoach(Coach coach) {
        ProjectInfo.currentCoach = coach;
    }

}
