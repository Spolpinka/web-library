package pro.sky.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import pro.sky.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));

    //get all employees
    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
