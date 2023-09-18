package edu.mum.cs.cs425.demowebapps.elibrary.service.impl;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import edu.mum.cs.cs425.demowebapps.elibrary.repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.elibrary.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> fetchStudents() {
        return repository.findAll();
    }

    @Override
    public Student updateDepartment(Student student, Long studentId) {
        Optional<Student> existingStudentOptional = repository.findById(studentId);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setStudentNumber(student.getStudentNumber());
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setMiddleName(student.getMiddleName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setCgpa(student.getCgpa());
            existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());
            return repository.save(existingStudent);
        } else {
            throw new EntityNotFoundException("Student with ID " + studentId + " not found");
        }
    }

    @Override
    public void deleteStudentById(Long studentId) {
        repository.deleteById(studentId);
    }

    @Override
    public Student findStudentById(Long studentId) {
        return repository.findById(studentId).get();
    }

    @Override
    public List<Student> searchStudentsByText(String searchText) {
        return repository.findByStudentNumberIgnoreCaseContainingOrFirstNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(searchText, searchText, searchText, searchText);
    }
}
