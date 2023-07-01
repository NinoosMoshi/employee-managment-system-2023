package com.ninos.service.imp;

import com.ninos.dto.EmployeeDTO;
import com.ninos.entity.Department;
import com.ninos.entity.Employee;
import com.ninos.exception.ResourceNotFountException;
import com.ninos.mapper.EmployeeMapper;
import com.ninos.repository.DepartmentRepository;
import com.ninos.repository.EmployeeRepository;
import com.ninos.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.convertToEmployee(employeeDTO);

        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFountException("department is not exists with id: " + employeeDTO.getDepartmentId()));
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.convertToDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employeeById = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFountException("Employee is not exists with the Id: "+ employeeId));
        return EmployeeMapper.convertToDTO(employeeById);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map((employee) ->
                EmployeeMapper.convertToDTO(employee)).collect(Collectors.toList());
    }


    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFountException("Employee is not exists with the Id: "+ employeeId));

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFountException("department is not exists with id: " + employeeDTO.getDepartmentId()));
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.convertToDTO(savedEmployee);
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFountException("Employee is not exists with the Id: "+ employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
