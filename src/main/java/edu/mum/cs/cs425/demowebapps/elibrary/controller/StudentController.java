package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Student;
import edu.mum.cs.cs425.demowebapps.elibrary.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/eregistrar/students"})
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping()
    public String displayStudentList(Model model) {
        List<Student> students = service.fetchStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/register")
    public String registerNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/register";
    }

    @PostMapping("/save")
    public String saveNewStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/updateStudent/{studentId}")
    public String showUpdateStudent(@PathVariable Long studentId, Model model) {
        Student existingStudent = service.findStudentById(studentId);
        model.addAttribute("student", existingStudent);
        return "student/edit";
    }

    @PostMapping("/saveUpdatedStudent")
    public String saveUpdateStudent(@ModelAttribute("student") Student student) {
        Student existingStudent = service.findStudentById(student.getStudentId());
        if (existingStudent != null){
           existingStudent.setStudentNumber(student.getStudentNumber());
           existingStudent.setFirstName(student.getFirstName());
           existingStudent.setMiddleName(student.getMiddleName());
           existingStudent.setLastName(student.getLastName());
           existingStudent.setCgpa(student.getCgpa());
           existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());
           existingStudent.setIsInternational(student.getIsInternational());
           service.saveStudent(existingStudent);
            return "redirect:/eregistrar/students";
        }
        return "student/edit";
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> showUpdateStudent(@PathVariable Long studentId) {
        Student existingStudent = service.findStudentById(studentId);
        if (existingStudent != null){
            service.deleteStudentById(studentId);
            return ResponseEntity.ok("Student deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to delete student");
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "searchQuery", required = false) String query, Model model) {
        List<Student> students = service.searchStudentsByText(query.trim());
        model.addAttribute("students", students);
        return "student/index";
    }
}
