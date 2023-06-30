package com.ninos.service.imp;

import com.ninos.dto.DepartmentDTO;
import com.ninos.entity.Department;
import com.ninos.exception.ResourceNotFountException;
import com.ninos.mapper.DepartmentMapper;
import com.ninos.repository.DepartmentRepository;
import com.ninos.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {

        Department department = DepartmentMapper.convertToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.convertToDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFountException("Department is not exists with the Id: "+ departmentId));
               return DepartmentMapper.convertToDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map((department) ->
            DepartmentMapper.convertToDTO(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFountException("Department is not exists with the Id: "+ departmentId));

        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.convertToDTO(savedDepartment);

    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFountException("Department is not exists with the Id: "+ departmentId));
        departmentRepository.deleteById(departmentId);
    }


}
