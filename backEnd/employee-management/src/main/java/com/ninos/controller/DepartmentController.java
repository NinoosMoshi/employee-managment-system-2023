package com.ninos.controller;

import com.ninos.dto.DepartmentDTO;
import com.ninos.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> allDepartments = departmentService.getAllDepartments();
        return ResponseEntity.ok(allDepartments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = departmentService.updateDepartment(departmentId, departmentDTO);
        return ResponseEntity.ok(departmentDTO1);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department delete successfully!");
    }





}
