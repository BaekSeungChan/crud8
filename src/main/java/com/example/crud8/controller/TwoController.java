package com.example.crud8.controller;


import com.example.crud8.payload.TwoDto;
import com.example.crud8.service.TwoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/two")
public class TwoController {

    private TwoService twoService;

    public TwoController(TwoService twoService){
        this.twoService = twoService;
    }

    @PostMapping
    public ResponseEntity<TwoDto> createTwo(@Valid @RequestBody TwoDto twoDto){
        return new ResponseEntity<>(twoService.createTwo(twoDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TwoDto>> getAllTwo(){
        return new ResponseEntity<>(twoService.getAllTwo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TwoDto> getTwoById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(twoService.getTwoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTwoById(@PathVariable(name = "id") long id){
        twoService.deleteTwoById(id);
        return ResponseEntity.ok("deleted Two");
    }

    @PutMapping("/{id}")
    public ResponseEntity<TwoDto> updateTwo(@PathVariable(name = "id")long id, @Valid @RequestBody TwoDto twoDto){
        TwoDto twoResponse = twoService.updateTwo(twoDto, id);
        return new ResponseEntity<>(twoResponse, HttpStatus.OK);
    }
}
