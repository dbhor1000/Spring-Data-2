package Javacode.Spring.Data2.projections;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface EmployeeProjection {
    @JsonIgnore
    String getFirstName();
    @JsonIgnore
    String getLastName();
    String getPosition();
    String getDepartmentName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}