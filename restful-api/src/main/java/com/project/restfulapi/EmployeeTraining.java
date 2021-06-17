package com.project.restfulapi;

import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeTraining {

    private final EmployeeRepository employeeRepository;
    private Object Employee;

    @Autowired
    public EmployeeTraining(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByemployeeId(employee.getId());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Employee already in enrolled for training");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(long employeeId) {
        boolean exists = employeeRepository.existsByEmployeeId(employeeId);
        if (!exists) {
            throw new IllegalStateException("Employee id not found");
        }
        employeeRepository.deleteByemployeeById(employeeId);

        }

    @Transactional
    public void updateEmployee(Long employeeId,String name,String training) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException("Employee with employee id doesn't exist"));
        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }
    }
 }




