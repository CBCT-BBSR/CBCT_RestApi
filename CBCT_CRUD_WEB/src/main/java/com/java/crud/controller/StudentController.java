package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Student;
import com.java.crud.repository.StudentRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.getStudent();
    }

    @GetMapping(value = "/{student_id}")
    public ResponseEntity<?> getStudent(@PathVariable("student_id") Integer student_id) {
        Student student = studentRepository.findById(student_id);
        if (student == null) {
            return new ResponseEntity<String>("No User found with this "+ student_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) throws SQLIntegrityConstraintViolationException {
        if (studentRepository.findById(student.getStudent_id()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ student.getStudent_id(), HttpStatus.IM_USED);
        }
        studentRepository.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (studentRepository.findById(student.getStudent_id()) == null) {
            return new ResponseEntity<String>("Unable to update as  Student id " + student.getStudent_id() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        studentRepository.updateStudent(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{student_id}")
    public ResponseEntity<?> deleteUser(@PathVariable("student_id") Integer student_id) {
    	 Student student = studentRepository.findById(student_id);
        if (student == null) {
            return new ResponseEntity<String>("Unable to delete as  Student id " + student_id + " not found.", HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteStudentById(student_id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

}
