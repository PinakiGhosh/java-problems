package com.bankbazaar.test.controller;

import com.bankbazaar.test.entity.Employee;
import com.bankbazaar.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {

        try {
            service.saveEmployee(employee);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(
                    "Invalid Department Id",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "Entry Successful",
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> findAllEmployee() {

        if (service.getEmployeeList()==null) {
            return new ResponseEntity<>(
                    "No Data",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getEmployeeList(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> findEmployeeById(@PathVariable Long id) {

        if (service.getEmployeeById(id).isEmpty()) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getEmployeeById(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> findEmployeeByName(@PathVariable String name) {

        if (service.getEmployeeByName(name)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getEmployeeByName(name),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {

        if (service.deleteEmployee(id)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.deleteEmployee(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {

        if (service.updateEmployee(employee)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.updateEmployee(employee),
                HttpStatus.OK);
    }
}


