package Javacode.Spring.Data2.service;

import Javacode.Spring.Data2.DTO.EmployeeDTO;
import Javacode.Spring.Data2.DTO.EmployeeNameDepartment;
import Javacode.Spring.Data2.DTO.UpdateEmployee;
import Javacode.Spring.Data2.model.DepartmentEntity;
import Javacode.Spring.Data2.model.EmployeeEntity;
import Javacode.Spring.Data2.projections.EmployeeProjection;
import Javacode.Spring.Data2.repository.DepartmentRepository;
import Javacode.Spring.Data2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<EmployeeProjection> findEmployee(EmployeeNameDepartment employeeNameDepartment) {

        return employeeRepository.findByFullNameAndDepartment(employeeNameDepartment.getFirstName(),
                employeeNameDepartment.getLastName(), employeeNameDepartment.getDepartmentName());

    }

    public EmployeeEntity addNewEmployee(EmployeeDTO addEmployee) {

        EmployeeEntity employeeFound = employeeRepository.findByAllFieldsExceptDepartment(addEmployee.getFirstName(), addEmployee.getLastName(), addEmployee.getPosition(),
                addEmployee.getSalary(), addEmployee.getDepartmentName());

        if (!departmentRepository.existsByName(addEmployee.getDepartmentName()) || employeeFound != null) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(0);
        employeeEntity.setFirstName(addEmployee.getFirstName());
        employeeEntity.setLastName(addEmployee.getLastName());
        employeeEntity.setSalary(addEmployee.getSalary());
        employeeEntity.setPosition(addEmployee.getPosition());
        DepartmentEntity department = departmentRepository.getReferenceByName(addEmployee.getDepartmentName());
        employeeEntity.setDepartment(department);
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }

    public EmployeeEntity updateEmployee(UpdateEmployee updateEmployee) {

        EmployeeEntity employeeFound = employeeRepository.findByAllFieldsExceptDepartment(updateEmployee.getOldFirstName(), updateEmployee.getOldLastName(), updateEmployee.getOldPosition(),
                updateEmployee.getOldSalary(), updateEmployee.getOldDepartmentName());
        EmployeeEntity employeeWithNewDataAlreadyExistsFound = employeeRepository.findByAllFieldsExceptDepartment(updateEmployee.getNewFirstName(),
                updateEmployee.getNewLastName(), updateEmployee.getNewPosition(),
                updateEmployee.getNewSalary(), updateEmployee.getNewDepartmentName());

        if(employeeFound == null || employeeWithNewDataAlreadyExistsFound != null || !departmentRepository.existsByName(updateEmployee.getNewDepartmentName())) {
            return null;
        }

        employeeFound.setFirstName(updateEmployee.getNewFirstName());
        employeeFound.setLastName(updateEmployee.getNewLastName());
        employeeFound.setPosition(updateEmployee.getNewPosition());
        employeeFound.setSalary(updateEmployee.getNewSalary());
        DepartmentEntity department = departmentRepository.getReferenceByName(updateEmployee.getNewDepartmentName());
        employeeFound.setDepartment(department);
        employeeRepository.save(employeeFound);
        return employeeFound;
    }

    public boolean deleteEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employeeFound = employeeRepository.findByAllFieldsExceptDepartment(employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getPosition(),
                employeeDTO.getSalary(), employeeDTO.getDepartmentName());

        if(employeeFound == null) {
            return false;
        }

        employeeRepository.deleteByAllFieldsExceptDepartment(employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getPosition(),
                employeeDTO.getSalary(), employeeDTO.getDepartmentName());
        return true;
    }

}
