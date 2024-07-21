package Javacode.Spring.Data2.service;

import Javacode.Spring.Data2.DTO.DepartmentName;
import Javacode.Spring.Data2.DTO.UpdateDepartment;
import Javacode.Spring.Data2.model.DepartmentEntity;
import Javacode.Spring.Data2.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity findDepartment(DepartmentName departmentName) {

        return departmentRepository.getReferenceByName(departmentName.getDepartmentName());

    }

    public DepartmentEntity addNewDepartment(DepartmentName departmentName) {

        if (departmentRepository.existsByName(departmentName.getDepartmentName())) {
            return null;
        }

        DepartmentEntity department = new DepartmentEntity();
        department.setId(0L);
        department.setName(departmentName.getDepartmentName());
        return departmentRepository.save(department);
    }

    public DepartmentEntity updateDepartment(UpdateDepartment updateDepartment) {

        DepartmentEntity departmentFound = departmentRepository.getReferenceByName(updateDepartment.getOldDepartmentName());
        DepartmentEntity departmentWithNewNameAlreadyExists = departmentRepository.getReferenceByName(updateDepartment.getNewDepartmentName());

        if(departmentFound == null || departmentWithNewNameAlreadyExists != null) {
            return null;
        }

        departmentFound.setName(updateDepartment.getNewDepartmentName());
        departmentRepository.save(departmentFound);
        return departmentFound;
    }

    public boolean deleteDepartment(DepartmentName departmentName) {

        DepartmentEntity departmentFound = departmentRepository.getReferenceByName(departmentName.getDepartmentName());

        if(departmentFound == null) {
            return false;
        }

        departmentRepository.deleteDepartmentByName(departmentName.getDepartmentName());
        return true;
    }

}
