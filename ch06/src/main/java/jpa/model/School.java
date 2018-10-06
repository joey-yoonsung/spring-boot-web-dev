package jpa.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class School {

    @Id
    @Column(name = "SCHOOL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String telnumber;

    @OneToMany(mappedBy = "school")
    private Set<Student> students = new HashSet<>();

    public School(String name) {
        this.name = name;
    }

    public void registerStudent(Student s) {
        students.add(s);
    }
}
