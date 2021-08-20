package com.altshuler.it_education_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
@Entity(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private int subgroupNum;
    @Column
    private String educationType;
    @Column
    private int price;
    @Column
    private String address;
    @Column
    private int numOfStudents;
    @Column
    private Date startDate;
    @Column
    private Date finishDate;
    @Column
    private int numOfLessons;
    @Column
    private String isStarted;
    @Column
    private String isFinished;
    @Column
    private int remaining;
    @Column
    private String coachRequired;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToOne(mappedBy = "course")
    private Stats stats;

    public void addStudent(Student student) {
        if (students == null) {
            Set<Student> studentEmptySet = new HashSet<>();
            studentEmptySet.add(student);
            setStudents(studentEmptySet);
        } else {
            students.add(student);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subgroupNum=" + subgroupNum +
                ", educationType='" + educationType + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", numOfStudents=" + numOfStudents +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", numOfLessons=" + numOfLessons +
                ", isStarted='" + isStarted + '\'' +
                ", isFinished='" + isFinished + '\'' +
                ", remaining=" + remaining +
                ", coachRequired='" + coachRequired + '\'' +
                '}';
    }
}
