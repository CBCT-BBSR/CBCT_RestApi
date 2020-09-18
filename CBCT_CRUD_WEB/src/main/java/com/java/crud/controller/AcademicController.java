package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Academic;
import com.java.crud.repository.AcademicRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/academic")
public class AcademicController {

    @Autowired
   AcademicRepository academicRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Academic> getAllAcademics(){
        return academicRepository.getAcademic();
    }

    @GetMapping(value = "/{academic_year}")
    public ResponseEntity<?> getAcademic(@PathVariable("academic_year") String academic_year) {
        Academic academic = academicRepository.findById(academic_year);
        if (academic_year == null) {
            return new ResponseEntity<String>("No Academic found with this "+ academic_year, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Academic>(academic, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAcademic(@RequestBody Academic academic) throws SQLIntegrityConstraintViolationException {
        if (academicRepository.findById(academic.getAcademic_year()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ academic.getAcademic_year(), HttpStatus.IM_USED);
        }
        academicRepository.saveAcademic(academic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> updateAcademic(@RequestBody Academic academic) {
        if (academicRepository.findById(academic.getAcademic_year()) == null) {
            return new ResponseEntity<String>("Unable to update as  Academic year " + academic.getAcademic_year() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        academicRepository.updateAcademic(academic);
        return new ResponseEntity<Academic>(academic, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{academic_year}")
    public ResponseEntity<?> deleteAcademic(@PathVariable("academic_year") String academic_year) {
    	 Academic academic = academicRepository.findById(academic_year);
        if (academic == null) {
            return new ResponseEntity<String>("Unable to delete as  Academic year " + academic_year + " not found.", HttpStatus.NOT_FOUND);
        }
        academicRepository.deleteAcademicById(academic_year);
        return new ResponseEntity<Academic>(HttpStatus.NO_CONTENT);
    }

}
