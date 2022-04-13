package com.bankbazaar.test.service;


import com.bankbazaar.test.entity.Employee;
import com.bankbazaar.test.repository.DepartmentRepository;
import com.bankbazaar.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    /**
     * Insert to Employee table
     * @param data
     */
    public Employee saveEmployee(Employee data)
    {
        if(departmentRepository.findById(data.getDepartmentId().getId()).isEmpty())
        {
            return null;
        }
        return employeeRepository.save(data);
    }

    /**
     * Print all record as list
     */
    public List<Employee> getEmployeeList() {

        return employeeRepository.findAll();
    }
    /**
     * Print record by ID
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    /**
     * Print records by name
     */
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }
    /**
     * Delete record by id
     */
    public String deleteEmployee(long id) {
        if(employeeRepository.findById(id).isEmpty())
        {
            return null;
        }
        employeeRepository.deleteById(id);
        return "Employee "+id+" has been removed" ;
    }
    /**
     * Update record
     */
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        if(existingEmployee==null)
        {
            return null;
        }
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

}
