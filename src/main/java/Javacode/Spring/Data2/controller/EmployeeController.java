package Javacode.Spring.Data2.controller;

import Javacode.Spring.Data2.DTO.EmployeeDTO;
import Javacode.Spring.Data2.DTO.EmployeeNameDepartment;
import Javacode.Spring.Data2.DTO.UpdateEmployee;
import Javacode.Spring.Data2.model.EmployeeEntity;
import Javacode.Spring.Data2.projections.EmployeeProjection;
import Javacode.Spring.Data2.service.DepartmentService;
import Javacode.Spring.Data2.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(DepartmentService departmentService, EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> fetchOneEmployee(@RequestBody EmployeeNameDepartment employeeNameDepartment) {

        List<EmployeeProjection> employeeFound = employeeService.findEmployee(employeeNameDepartment);
        if(employeeFound == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeFound);
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> newEmployee(@RequestBody EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = employeeService.addNewEmployee(employeeDTO);

        if(employeeEntity == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(employeeEntity);
    }

    @PatchMapping()
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody UpdateEmployee updateEmployee) {

        EmployeeEntity updatedEmployee = employeeService.updateEmployee(updateEmployee);

        if(updatedEmployee == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteBook(@RequestBody EmployeeDTO employeeDTO) {

        if (employeeService.deleteEmployee(employeeDTO)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
