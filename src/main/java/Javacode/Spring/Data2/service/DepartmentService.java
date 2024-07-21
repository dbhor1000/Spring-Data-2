package Javacode.Spring.Data2.service;

import Javacode.Spring.Data2.DTO.DepartmentName;
import Javacode.Spring.Data2.DTO.UpdateDepartment;
import Javacode.Spring.Data2.model.DepartmentEntity;

public interface DepartmentService {

    public DepartmentEntity findDepartment(DepartmentName departmentName);
    public DepartmentEntity addNewDepartment(DepartmentName departmentName);
    public DepartmentEntity updateDepartment(UpdateDepartment updateDepartment);
    public boolean deleteDepartment(DepartmentName departmentName);

}
