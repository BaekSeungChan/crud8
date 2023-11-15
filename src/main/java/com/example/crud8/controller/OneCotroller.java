package com.example.crud8.controller;


import com.example.crud8.payload.OneDto;
import com.example.crud8.service.OneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/one")
public class OneCotroller {

    private OneService oneService;

    public OneCotroller(OneService oneService){
        this.oneService = oneService;
    }

    @PostMapping
    public ResponseEntity<OneDto> createOne(@Valid @RequestBody OneDto oneDto){
        return new ResponseEntity<>(oneService.createOne(oneDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OneDto>> getAllOne(){
        return new ResponseEntity<>(oneService.getAllOne(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OneDto> getOneById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(oneService.getOneById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable(name = "id") long id){
        oneService.deleteOneById(id);
        return ResponseEntity.ok("deleted One");
    }

    @PutMapping("/{id}")
    public ResponseEntity<OneDto> updateOne(@PathVariable(name = "id")long id, @Valid @RequestBody OneDto oneDto){
        OneDto oneResponse = oneService.updateOne(oneDto, id);
        return new ResponseEntity<>(oneResponse, HttpStatus.OK);
    }

}
