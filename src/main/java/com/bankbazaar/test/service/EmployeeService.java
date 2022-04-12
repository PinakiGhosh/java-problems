package com.bankbazaar.test.service;


import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.entity.Employee;
import com.bankbazaar.test.repository.EmployeeRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeRepository departmentRepository;
    /**
     * Insert to Employee table
     * @param data
     */
    public Employee saveEmployee(Employee data)
    {
        try {
            /**
             * Get department data
             */
            final String uriGet = "http://localhost:8080/departmentById/"+data.getDepartmentId().getId();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic YWRtaW46YWRtaW4xMjM0");
            HttpEntity request = new HttpEntity(headers);

            ResponseEntity<String> response = new RestTemplate().exchange(uriGet, HttpMethod.GET, request, String.class);

            JsonObject departmentData = JsonParser.parseString(response.getBody()).getAsJsonObject();
            /**
             * Store new employee count
             */
            int employeeCount = departmentData.get("employeeCount").getAsInt()+1;

            /**
             * Update department details
             */
            final String uriPut = "http://localhost:8080/updateDepartment";

            Department department =new Department();
            department.setId(departmentData.get("id").getAsInt());
            department.setEmployeeCount(employeeCount);
            department.setName(departmentData.get("name").getAsString());

            HttpEntity<Department> update = new HttpEntity<Department>(department,headers);

            new RestTemplate().exchange(uriPut, HttpMethod.PUT, update, String.class);

        }
        catch (Exception e)
        {
            System.out.println("The provided department ID doesn't exist");
            return null;
        }

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
