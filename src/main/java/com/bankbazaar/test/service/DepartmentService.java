package com.bankbazaar.test.service;


import com.bankbazaar.test.entity.Department;
import com.bankbazaar.test.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * Print all record as list
     */
    public List<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }
    /**
     * Print record by ID
     */
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
    /**
     * Print records by name
     */
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
    /**
     * Delete record by id
     * @param id
     */
    public String deleteDepartment(Long id) {
        if(departmentRepository.findById(id).isEmpty())
        {
            return null;
        }
        departmentRepository.deleteById(id);
        return "Department "+id+" has been removed" ;
    }
    /**
     * Update record
     */
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        if(existingDepartment==null)
        {
            return null;
        }
        existingDepartment.setName(department.getName());
        existingDepartment.setDepartmentPhone(department.getDepartmentPhone());
        existingDepartment.setDepartmentFloor(department.getDepartmentFloor());
        return departmentRepository.save(existingDepartment);
    }

}
