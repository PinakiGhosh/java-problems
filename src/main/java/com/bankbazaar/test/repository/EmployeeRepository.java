package com.bankbazaar.test.repository;
import com.bankbazaar.test.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByName(String name);
}
