package com.bankbazaar.test.controller;

import com.bankbazaar.test.entity.Employee;
import com.bankbazaar.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

        Employee response = service.saveEmployee(employee);
        if(response == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployee() {

        List<Employee> employeeData = service.getEmployeeList();
        if (employeeData==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @RequestMapping(value="/id",method = RequestMethod.GET)
    public ResponseEntity<Optional<Employee>> findEmployeeById(@RequestParam Long id) {

        Optional<Employee> employeeData = service.getEmployeeById(id);
        if (employeeData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @RequestMapping(value="/name",method = RequestMethod.GET)
    public ResponseEntity<Employee> findEmployeeByName(@RequestParam String name) {

        Employee employeeData = service.getEmployeeByName(name);
        if (employeeData==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employeeData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@RequestParam Long id) {

        if (service.deleteEmployee(id)==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {

        Employee response = service.updateEmployee(employee);
        if(response == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
