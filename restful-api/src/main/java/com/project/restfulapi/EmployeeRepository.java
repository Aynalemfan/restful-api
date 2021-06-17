package com.project.restfulapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByemployeeId(Long id);

    boolean existsByEmployeeId(long employeeId);

    void deleteByemployeeById(long employeeId);
}
