package com.example.crud8.controller;


import com.example.crud8.payload.OneDto;
import com.example.crud8.service.OneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/one")
@Tag(name = "One api's")
public class OneCotroller {

    private OneService oneService;

    public OneCotroller(OneService oneService){
        this.oneService = oneService;
    }

    @PostMapping
    @Operation(
            summary = "Create one",
            description = "Create one API"
    )
    public ResponseEntity<OneDto> createOne(@Valid @RequestBody OneDto oneDto){
        return new ResponseEntity<>(oneService.createOne(oneDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "All one",
            description = "All one API"
    )
    public ResponseEntity<List<OneDto>> getAllOne(){
        return new ResponseEntity<>(oneService.getAllOne(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "detail one",
            description = "detail one API"
    )
    public ResponseEntity<OneDto> getOneById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(oneService.getOneById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "delete one",
            description = "delete one API"
    )
    public ResponseEntity<String> deleteOneById(@PathVariable(name = "id") long id){
        oneService.deleteOneById(id);
        return ResponseEntity.ok("deleted One");
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "update one",
            description = "update one API"
    )
    public ResponseEntity<OneDto> updateOne(@PathVariable(name = "id")long id, @Valid @RequestBody OneDto oneDto){
        OneDto oneResponse = oneService.updateOne(oneDto, id);
        return new ResponseEntity<>(oneResponse, HttpStatus.OK);
    }

}
