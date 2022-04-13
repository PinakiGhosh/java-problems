package com.bankbazaar.test.controller;

import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {

        Department response = service.saveDepartment(department);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Department>> findAllDepartment() {

        List<Department> departmentData = service.getDepartmentList();
        if (departmentData==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(departmentData, HttpStatus.OK);
    }

    @RequestMapping(value="/id",method = RequestMethod.GET)
    public ResponseEntity<Optional<Department>> findDepartmentById(@RequestParam Long id) {

        Optional<Department> departmentData = service.getDepartmentById(id);
        if (departmentData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(departmentData, HttpStatus.OK);
    }

    @RequestMapping(value="/name",method = RequestMethod.GET)
    public ResponseEntity<Department> findDepartmentByName(@RequestParam String name) {

        Department departmentData = service.getDepartmentByName(name);
        if (departmentData==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(departmentData, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Department> deleteDepartment(@RequestParam Long id) {

        if (service.deleteDepartment(id)==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department) {

        Department response = service.updateDepartment(department);
        if(response == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
