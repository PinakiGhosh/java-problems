package com.bankbazaar.test.controller;

import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {

        try {
            service.saveDepartment(department);
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
    public ResponseEntity<String> findAllDepartment() {

        if (service.getDepartmentList()==null) {
            return new ResponseEntity<>(
                    "No Data",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getDepartmentList(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> findDepartmentById(@PathVariable Long id) {

        if (service.getDepartmentById(id).isEmpty()) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getDepartmentById(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> findDepartmentByName(@PathVariable String name) {

        if (service.getDepartmentByName(name)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.getDepartmentByName(name),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDepartment(@PathVariable long id) {

        if (service.deleteDepartment(id)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.deleteDepartment(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {

        if (service.updateDepartment(department)==null) {
            return new ResponseEntity<>(
                    "Invalid ID",
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                "" + service.updateDepartment(department),
                HttpStatus.OK);
    }
}
