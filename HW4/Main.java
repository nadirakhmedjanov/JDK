package HW4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee employee1 = new Employee("Шухрат Азизов", "+998909999999", 4);
        Employee employee2 = new Employee("Сергей Полищук", "+998978551542", 12);

        employeeBook.addEmployeeToEmployeeBook(employee1);
        employeeBook.addEmployeeToEmployeeBook(employee2);

        List<Employee> experiencedEmployees = employeeBook.searchEmployeeByExperience(4);
        List<String> phoneNumbers = employeeBook.searchEmployeePhoneNumberByName("Шухрат Азизов");
        Employee foundEmployee = employeeBook.searchEmployeeByID(2);

        System.out.println("Сотрудники со стажем 4 года: " + experiencedEmployees);
        System.out.println("Номера телефонов сотрудников по имени 'Шухрат Азизов': " + phoneNumbers);
        System.out.println("Найденный сотрудник по ID 2: " + foundEmployee);
    }
}