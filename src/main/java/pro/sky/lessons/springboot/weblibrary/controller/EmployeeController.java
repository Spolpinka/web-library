package pro.sky.lessons.springboot.weblibrary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.lessons.springboot.weblibrary.model.Employee;
import pro.sky.lessons.springboot.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showHelloWorld() {
        return "Hello, employee!";
    }
    //get sum of all salaries
    @GetMapping("/salary/sum")
    public ResponseEntity<Integer> sumOfSalaries() {
        return ResponseEntity.ok(employeeService.sumOfSalaries());
    }
    //get Employee with min salary
    @GetMapping("/salary/min")
    public ResponseEntity<Employee> minSalary() {
        return ResponseEntity.ok(employeeService.minSalary());
    }
    //get Employee with max salary
    @GetMapping("/salary/max")
    public ResponseEntity<Employee> maxSalary() {
        return ResponseEntity.ok(employeeService.maxSalary());
    }

    //get employee with salary higher than average
    @GetMapping("/high-salary")
    public ResponseEntity<List<Employee>> highSalary() {
        return ResponseEntity.ok(employeeService.highSalary());
    }
}
