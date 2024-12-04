package com.example.code;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private LocalDate dateOfJoining;

    // Constructor
    public Employee(int id, String name, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", dateOfJoining=" + dateOfJoining +
               '}';
    }
}

public class FilterEmployees {
    public static void main(String[] args) {
      
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vaibhav", LocalDate.of(2021, 5, 10)));
        employees.add(new Employee(2, "Sonali", LocalDate.of(2020, 3, 15)));
        employees.add(new Employee(3, "ram", LocalDate.of(2023, 1, 20)));
        employees.add(new Employee(4, "Dinesh", LocalDate.of(2022, 7, 5)));

      
        LocalDate filterDate = LocalDate.of(2022, 1, 1);

     
        List<Employee> filteredEmployees = employees.stream()
            .filter(emp -> emp.getDateOfJoining().isAfter(filterDate))
            .collect(Collectors.toList());

        // Print the filtered employees
        filteredEmployees.forEach(System.out::println);
    }
}
