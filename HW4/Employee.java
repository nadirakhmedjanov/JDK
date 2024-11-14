package HW4;

public class Employee {
    private static int startPositionForID = 0; 
    private final int employeeID;
    private String employeeName;
    private String employeePhoneNumber;
    private int employeeExperience;

    
    public Employee(String employeeName, String employeePhoneNumber, int employeeExperience) {
        this.employeeID = ++startPositionForID;
        this.employeeName = employeeName;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeExperience = employeeExperience;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public int getEmployeeExperience() {
        return employeeExperience;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public void setEmployeeExperience(int employeeExperience) {
        this.employeeExperience = employeeExperience;
    }

    
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeeExperience=" + employeeExperience +
                '}';
    }
}
