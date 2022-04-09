package com.bankbazaar.test.service;


import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Insert to Department table
     * @param data
     */
    public Department saveDepartment(Department data)
    {
        return departmentRepository.save(data);
    }
    /**
     * Insert List to Department table
     * @param dataList
     */
    public List<Department> saveDepartmentList(List<Department> dataList)
    {
        return departmentRepository.saveAll(dataList);
    }
    /**
     * Print all record as list
     */
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }
    /**
     * Print record by ID
     */
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
    /**
     * Print records by name
     */
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
    /**
     * Delete record by id
     */
    public String deleteDepartment(int id) {
        departmentRepository.deleteById(id);
        return "Department "+id+" has been removed" ;
    }
    /**
     * Update record
     */
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        existingDepartment.setName(department.getName());
        existingDepartment.setEmployeeCount(department.getEmployeeCount());
        return departmentRepository.save(existingDepartment);
    }



}
