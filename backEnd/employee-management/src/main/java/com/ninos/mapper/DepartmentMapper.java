package com.ninos.mapper;

import com.ninos.dto.DepartmentDTO;
import com.ninos.entity.Department;
import org.springframework.beans.BeanUtils;

public class DepartmentMapper {


    public static DepartmentDTO convertToDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentDTO);
        return departmentDTO;
    }


    public static Department convertToDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        return department;
    }


}
