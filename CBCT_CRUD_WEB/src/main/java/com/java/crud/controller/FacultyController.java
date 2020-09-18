package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Faculty;
import com.java.crud.repository.FacultyRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
   FacultyRepository facultyRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Faculty> getAllFaculties(){
        return facultyRepository.getFaculty();
    }

    @GetMapping(value = "/{facultyid}")
    public ResponseEntity<?> getFaculty(@PathVariable("facultyid") Integer facultyid) {
        Faculty faculty = facultyRepository.findById(facultyid);
        if (faculty == null) {
            return new ResponseEntity<String>("No User found with this "+ facultyid, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createFaculty(@RequestBody Faculty faculty) throws SQLIntegrityConstraintViolationException {
        if (facultyRepository.findById(faculty.getFacultyid()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ faculty.getFacultyid(), HttpStatus.IM_USED);
        }
        facultyRepository.saveFaculty(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateFaculty(@RequestBody Faculty faculty) {
        if (facultyRepository.findById(faculty.getFacultyid()) == null) {
            return new ResponseEntity<String>("Unable to update as  Faculty id " + faculty.getFacultyid() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        facultyRepository.updateFaculty(faculty);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{facultyid}")
    public ResponseEntity<?> deleteFaculty(@PathVariable("facultyid") Integer facultyid) {
    	 Faculty faculty = facultyRepository.findById(facultyid);
        if (faculty == null) {
            return new ResponseEntity<String>("Unable to delete as  Faculty id " + facultyid + " not found.", HttpStatus.NOT_FOUND);
        }
        facultyRepository.deleteFacultyById(facultyid);
        return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
    }

}
