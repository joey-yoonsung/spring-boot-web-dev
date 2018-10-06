package jpa.service;

import jpa.model.School;
import jpa.model.Student;
import jpa.repository.SchoolRepository;
import jpa.repository.StudentRepository;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void findSchoolInfo() {
        School sc1 = new School("예체능고");
        sc1.registerStudent(new Student("엄재현"));
        sc1.registerStudent(new Student("민찬규"));

        School sc2 = new School("매력고");
        sc2.registerStudent(new Student("박지영"));
        sc2.registerStudent(new Student("윤성"));


        schoolRepository.save(sc1);
        schoolRepository.save(sc2);
        List<School> schools = schoolRepository.findAll();

        for (School s : schools) {
            System.out.println(ToStringBuilder.reflectionToString(s, ToStringStyle.DEFAULT_STYLE));
        }
    }
    @Transactional
    public void findStudentInfo(){
        School school = new School("매력고");
        schoolRepository.save(school);

        Student student1 = new Student("윤성");
        Student student2 = new Student("지영");
        Student student3 = new Student("정은");

        student1.setSchool(school);
        student2.setSchool(school);
        student3.setSchool(school);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        List<Student> students = studentRepository.findAll();

        for (Student s : students) {
            System.out.println(ToStringBuilder.reflectionToString(s, ToStringStyle.DEFAULT_STYLE));
        }
    }
}
