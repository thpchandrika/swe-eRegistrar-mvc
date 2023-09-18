package edu.mum.cs.cs425.demowebapps.elibrary.service;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> fetchStudents();
    Student updateDepartment(Student student,
                                Long studentId);
    void deleteDepartmentById(Long studentId);
}


