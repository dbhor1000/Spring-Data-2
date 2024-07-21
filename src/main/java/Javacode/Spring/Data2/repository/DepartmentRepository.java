package Javacode.Spring.Data2.repository;

import Javacode.Spring.Data2.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    boolean existsByName(String name);
    DepartmentEntity getReferenceByName(String name);
    @Transactional
    @Modifying
    @Query("DELETE FROM department_table d WHERE d.name = :name")
    void deleteDepartmentByName(@Param("name") String name);
}