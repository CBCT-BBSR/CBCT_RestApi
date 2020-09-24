package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Subject;
import com.java.crud.repository.SubjectRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectRepository.getSubject();
    }

    @GetMapping(value = "/{subject_code}")
    public ResponseEntity<?> getSubject(@PathVariable("subject_code") String subject_code) {
        Subject subject = subjectRepository.findById(subject_code);
        if (subject == null) {
            return new ResponseEntity<String>("No Subject found with this "+ subject_code, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createSubject(@RequestBody Subject subject) throws SQLIntegrityConstraintViolationException {
        if (subjectRepository.findById(subject.getSubject_code()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ subject.getSubject_code(), HttpStatus.IM_USED);
        }
        subjectRepository.saveSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject) {
        if (subjectRepository.findById(subject.getSubject_code()) == null) {
            return new ResponseEntity<String>("Unable to update as  Subject Code " + subject.getSubject_code() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        subjectRepository.updateSubject(subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{subject_code}")
    public ResponseEntity<?> deleteSubject(@PathVariable("subject_code") String subject_code) {
    	 Subject subject = subjectRepository.findById(subject_code);
        if (subject == null) {
            return new ResponseEntity<String>("Unable to delete as  Subject code " + subject_code + " not found.", HttpStatus.NOT_FOUND);
        }
        subjectRepository.deleteSubjectById(subject_code);
        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
    }

}
