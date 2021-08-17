package com.altshuler.it_education_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "coaches")
@Entity(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @OneToMany(mappedBy = "coach", fetch = FetchType.EAGER)
    Set<Course> courseSet = new HashSet<>();

    public void addCourse(Course course) {
        if (courseSet == null) {
            Set<Course> courseEmptySet = new HashSet<>();
            courseEmptySet.add(course);
            setCourseSet(courseEmptySet);
        } else {
            courseSet.add(course);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return id == coach.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
