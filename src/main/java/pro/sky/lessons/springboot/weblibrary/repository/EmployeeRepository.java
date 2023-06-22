package pro.sky.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import pro.sky.lessons.springboot.weblibrary.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository {
    //get all employees
    List<Employee> getAllEmployees();
}
