package com.bankbazaar.test.service;


import com.bankbazaar.test.entity.Employee;
import com.bankbazaar.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Insert to Employee table
     * @param data
     */
    public Employee saveEmployee(Employee data)
    {
        return employeeRepository.save(data);
    }
    /**
     * Insert List to Employee table
     * @param dataList
     */
    public List<Employee> saveEmployeeList(List<Employee> dataList)
    {
        return employeeRepository.saveAll(dataList);
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
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
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
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee "+id+" has been removed" ;
    }
    /**
     * Update record
     */
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }
    


}
