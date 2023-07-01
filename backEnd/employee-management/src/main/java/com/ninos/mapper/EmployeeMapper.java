package com.ninos.mapper;

import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeMapper {


    public static EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        employeeDTO.setDepartmentId(employee.getDepartment().getId());
        return employeeDTO;
    }


    public static Employee convertToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }


}
