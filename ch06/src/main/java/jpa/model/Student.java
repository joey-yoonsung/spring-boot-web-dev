package jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String grade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHOOL_ID")
    private School school;

    public Student(String userName) {
        this.userName = userName;
    }
}
