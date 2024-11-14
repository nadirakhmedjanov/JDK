package HW4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EmployeeBook {
    
    private final Map<Integer, Employee> employeeMap;

    public EmployeeBook() {
        this.employeeMap = new HashMap<>();
    }

    
    public List<Employee> searchEmployeeByExperience(int employeeExpectedExperience) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getEmployeeExperience() == employeeExpectedExperience)
                .collect(Collectors.toList());
    }

   
    public List<String> searchEmployeePhoneNumberByName(String employeeName) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getEmployeeName().equals(employeeName))
                .map(employee -> String.format("Имя сотрудника: %s, и номер его телефона: %s", employee.getEmployeeName(), employee.getEmployeePhoneNumber()))
                .collect(Collectors.toList());
    }

    
    public Employee searchEmployeeByID(int providedEmployeeID) {
        return employeeMap.get(providedEmployeeID); // Быстрый поиск по табельному номеру
    }

   
    public boolean addEmployeeToEmployeeBook(Employee employee) {
        if (employeeMap.containsKey(employee.getEmployeeID())) {
            return false; // Сотрудник с таким табельным номером уже существует
        }
        employeeMap.put(employee.getEmployeeID(), employee); // Добавление в Map для быстрого поиска
        return true;
    }
}