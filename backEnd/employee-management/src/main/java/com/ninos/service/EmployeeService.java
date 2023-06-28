package com.ninos.service;

import com.ninos.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);
    void deleteEmployee(Long employeeId);

}
