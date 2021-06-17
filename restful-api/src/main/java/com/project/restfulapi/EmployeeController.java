package com.example.restfulapi;

import com.project.restfulapi.Employee;
import com.project.restfulapi.EmployeeTraining;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="api/employee")
public class EmployeeController {

    private final EmployeeTraining employeeTraining;

    @Autowired
    public EmployeeController(EmployeeTraining employeeTraining) {
        this.employeeTraining = employeeTraining;
    }

    @GetMapping
    public List<Employee> getEmployee() {

        return employeeTraining.getEmployees();

    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeTraining.addEmployee(employee);
    }

    @DeleteMapping(path="{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") long employeeId) {
        employeeTraining.deleteEmployee(employeeId);
    }

    @PutMapping(path = "employeeId")
    public void UpdateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required =false) String name,
            @RequestParam(required = false) String training) {
        employeeTraining.updateEmployee(employeeId, name, training);
    }
}
