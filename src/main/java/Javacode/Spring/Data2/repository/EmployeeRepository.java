package Javacode.Spring.Data2.repository;


import Javacode.Spring.Data2.model.EmployeeEntity;
import Javacode.Spring.Data2.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT e.firstName AS firstName, e.lastName AS lastName, e.position AS position, d.name AS departmentName " +
            "FROM employee_table e JOIN e.department d " +
            "WHERE e.firstName = :firstName AND e.lastName = :lastName AND d.name = :departmentName")
    List<EmployeeProjection> findByFullNameAndDepartment(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("departmentName") String departmentName);

    @Query("SELECT e FROM employee_table e JOIN e.department d " +
            "WHERE e.firstName = :firstName AND e.lastName = :lastName AND e.position = :position " +
            "AND e.salary = :salary AND d.name = :departmentName")
    EmployeeEntity findByAllFieldsExceptDepartment(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("position") String position,
                                                   @Param("salary") BigDecimal salary, @Param("departmentName") String departmentName);

    @Transactional
    @Modifying
    @Query("DELETE FROM employee_table e WHERE e.firstName = :firstName AND e.lastName = :lastName AND e.position = :position " +
            "AND e.salary = :salary AND e.department.name = :departmentName")
    void deleteByAllFieldsExceptDepartment(@Param("firstName") String firstName, @Param("lastName") String lastName,
                                           @Param("position") String position, @Param("salary") BigDecimal salary,
                                           @Param("departmentName") String departmentName);
}

