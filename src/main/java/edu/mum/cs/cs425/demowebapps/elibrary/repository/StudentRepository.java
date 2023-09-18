package edu.mum.cs.cs425.demowebapps.elibrary.repository;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentNumberIgnoreCaseContainingOrFirstNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String searchText1, String searchText2, String searchText3, String searchText4);
}
