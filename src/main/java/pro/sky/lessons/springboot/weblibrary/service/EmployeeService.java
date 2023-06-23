package pro.sky.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import pro.sky.lessons.springboot.weblibrary.model.Employee;
import pro.sky.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //get sum of all salaries
    public int sumOfSalaries() {
        return employeeRepository.getAllEmployees().stream()
                .mapToInt(employee -> employee.getSalary())
                .sum();
    }

    //get Employee with min salary
    public Employee minSalary() {
        return employeeRepository.getAllEmployees().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .get();
    }

    //get Employee with max salary
    public Employee maxSalary() {
        return employeeRepository.getAllEmployees().stream().max(Comparator.comparingInt(Employee::getSalary)).get();
    }

    //get employee with salary higher than average
    public List<Employee> highSalary(){
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > employeeRepository.getAllEmployees().stream()
                        .mapToInt(Employee::getSalary)
                        .average()
                        .getAsDouble())
                .collect(Collectors.toList());
    }
}
