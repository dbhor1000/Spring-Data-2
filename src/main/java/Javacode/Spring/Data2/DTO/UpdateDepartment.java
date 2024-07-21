package Javacode.Spring.Data2.DTO;

public class UpdateDepartment {

    private String oldDepartmentName;
    private String newDepartmentName;

    public String getNewDepartmentName() {
        return newDepartmentName;
    }

    public void setNewDepartmentName(String newDepartmentName) {
        this.newDepartmentName = newDepartmentName;
    }

    public String getOldDepartmentName() {
        return oldDepartmentName;
    }

    public void setOldDepartmentName(String oldDepartmentName) {
        this.oldDepartmentName = oldDepartmentName;
    }
}
