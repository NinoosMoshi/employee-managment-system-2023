package com.ninos.service;

import com.ninos.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService  {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentById(Long departmentId);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);
    void deleteDepartment(Long departmentId);


}
