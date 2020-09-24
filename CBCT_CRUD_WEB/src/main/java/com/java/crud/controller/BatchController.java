package com.java.crud.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.crud.model.Batch;
import com.java.crud.repository.BatchRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    BatchRepository batchRepository;

    @GetMapping("/test")
    public String test(){
        String testing = "testing";
        return testing;
    }


    @GetMapping
    public List<Batch> getAllBatchs(){
        return batchRepository.getBatch();
    }

    @GetMapping(value = "/{batch_id}")
    public ResponseEntity<?> getBatch(@PathVariable("batch_id") String batch_id) {
        Batch batch = batchRepository.findById(batch_id);
        if (batch == null) {
            return new ResponseEntity<String>("No User found with this "+ batch_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Batch>(batch, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBatch(@RequestBody Batch batch) throws SQLIntegrityConstraintViolationException {
        if (batchRepository.findById(batch.getBatch_id()) != null) {
            return new ResponseEntity<String>("Duplicate Entry "+ batch.getBatch_id(), HttpStatus.IM_USED);
        }
        batchRepository.saveBatch(batch);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{batch_id}")
    public ResponseEntity<?> deleteBatch(@PathVariable("batch_id") String batch_id) {
    	 Batch batch = batchRepository.findById(batch_id);
        if (batch == null) {
            return new ResponseEntity<String>("Unable to delete as  Batch id " + batch_id + " not found.", HttpStatus.NOT_FOUND);
        }
        batchRepository.deleteBatchById(batch_id);
        return new ResponseEntity<Batch>(HttpStatus.NO_CONTENT);
    }

}
