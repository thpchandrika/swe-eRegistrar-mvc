package edu.mum.cs.cs425.demowebapps.elibrary.service;
import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> fetchStudents();
    Student updateStudent(Student student,
                                Long studentId);
    void deleteStudentById(Long studentId);
    Student findStudentById(Long studentId);
    List<Student> searchStudentsByText(String searchText);
}


