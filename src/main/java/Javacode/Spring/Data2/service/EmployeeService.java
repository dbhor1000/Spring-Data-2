package Javacode.Spring.Data2.service;

import Javacode.Spring.Data2.DTO.EmployeeDTO;
import Javacode.Spring.Data2.DTO.EmployeeNameDepartment;
import Javacode.Spring.Data2.DTO.UpdateEmployee;
import Javacode.Spring.Data2.model.EmployeeEntity;
import Javacode.Spring.Data2.projections.EmployeeProjection;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeProjection> findEmployee(EmployeeNameDepartment employeeNameDepartment);
    public EmployeeEntity addNewEmployee(EmployeeDTO addEmployee);
    public EmployeeEntity updateEmployee(UpdateEmployee updateEmployee);
    public boolean deleteEmployee(EmployeeDTO employeeDTO);

}
