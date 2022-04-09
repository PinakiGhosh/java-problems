package com.bankbazaar.test.controller;

import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);
    }

    @PostMapping("/addDepartmentList")
    public List<Department> addDepartmentList(@RequestBody List<Department> departments) {
        return service.saveDepartmentList(departments);
    }

    @GetMapping("/department")
    public List<Department> findAllDepartment() {
        return service.getDepartmentList();
    }

    @GetMapping("/departmentById/{id}")
    public Department findDepartmentById(@PathVariable int id) {
        return service.getDepartmentById(id);
    }

    @GetMapping("/department/{name}")
    public Department findDepartmentByName(@PathVariable String name) {
        return service.getDepartmentByName(name);
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return service.deleteDepartment(id);
    }
}
