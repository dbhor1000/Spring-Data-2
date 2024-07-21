package Javacode.Spring.Data2.controller;

import Javacode.Spring.Data2.DTO.*;
import Javacode.Spring.Data2.model.DepartmentEntity;
import Javacode.Spring.Data2.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<?> fetchOneDepartment(@RequestBody DepartmentName departmentName) {

        DepartmentEntity departmentFound = departmentService.findDepartment(departmentName);
        if(departmentFound == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(departmentFound);
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> newDepartment(@RequestBody DepartmentName departmentName) {

        DepartmentEntity department = departmentService.addNewDepartment(departmentName);

        if(department == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(department);
    }

    @PatchMapping()
    public ResponseEntity<DepartmentEntity> updateDepartment(@RequestBody UpdateDepartment updateDepartment) {

        DepartmentEntity updatedDepartment = departmentService.updateDepartment(updateDepartment);

        if(updatedDepartment == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteDepartment(@RequestBody DepartmentName departmentName) {

        if (departmentService.deleteDepartment(departmentName)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
