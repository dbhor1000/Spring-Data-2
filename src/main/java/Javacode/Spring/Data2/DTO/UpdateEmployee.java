package Javacode.Spring.Data2.DTO;

import java.math.BigDecimal;

public class UpdateEmployee {

    private String oldFirstName;
    private String oldLastName;
    private String oldPosition;
    private BigDecimal oldSalary;
    private String oldDepartmentName;
    private String newFirstName;
    private String newLastName;
    private String newPosition;
    private BigDecimal newSalary;
    private String newDepartmentName;

    public String getNewDepartmentName() {
        return newDepartmentName;
    }

    public void setNewDepartmentName(String newDepartmentName) {
        this.newDepartmentName = newDepartmentName;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(String newPosition) {
        this.newPosition = newPosition;
    }

    public BigDecimal getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(BigDecimal newSalary) {
        this.newSalary = newSalary;
    }

    public String getOldDepartmentName() {
        return oldDepartmentName;
    }

    public void setOldDepartmentName(String oldDepartmentName) {
        this.oldDepartmentName = oldDepartmentName;
    }

    public String getOldFirstName() {
        return oldFirstName;
    }

    public void setOldFirstName(String oldFirstName) {
        this.oldFirstName = oldFirstName;
    }

    public String getOldLastName() {
        return oldLastName;
    }

    public void setOldLastName(String oldLastName) {
        this.oldLastName = oldLastName;
    }

    public String getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(String oldPosition) {
        this.oldPosition = oldPosition;
    }

    public BigDecimal getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(BigDecimal oldSalary) {
        this.oldSalary = oldSalary;
    }
}
