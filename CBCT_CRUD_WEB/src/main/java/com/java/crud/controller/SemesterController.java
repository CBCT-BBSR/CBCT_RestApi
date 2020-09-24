package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Semester;
import com.java.crud.repository.SemesterRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/semester")
public class SemesterController {

    @Autowired
    SemesterRepository semesterRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Semester> getAllSemesters(){
        return semesterRepository.getSemester();
    }

    @GetMapping(value = "/{semesterid}")
    public ResponseEntity<?> getSemester(@PathVariable("semester_id") String semester_id) {
        Semester semester = semesterRepository.findById(semester_id);
        if (semester == null) {
            return new ResponseEntity<String>("No User found with this "+ semester_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Semester>(semester, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBatch(@RequestBody Semester semester) throws SQLIntegrityConstraintViolationException {
        if (semesterRepository.findById(semester.getSemester_id()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ semester.getSemester_id(), HttpStatus.IM_USED);
        }
        semesterRepository.saveSemester(semester);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{semester_id}")
    public ResponseEntity<?> deleteSemester(@PathVariable("semester_id") String semester_id) {
    	 Semester semester = semesterRepository.findById(semester_id);
        if (semester == null) {
            return new ResponseEntity<String>("Unable to delete as  Semester id " + semester_id + " not found.", HttpStatus.NOT_FOUND);
        }
        semesterRepository.deleteSemesterById(semester_id);
        return new ResponseEntity<Semester>(HttpStatus.NO_CONTENT);
    }

}
