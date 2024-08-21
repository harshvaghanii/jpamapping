package com.example.codingshuttle.jpamapping.jpamapping.services;

import com.example.codingshuttle.jpamapping.jpamapping.entities.DepartmentEntity;
import com.example.codingshuttle.jpamapping.jpamapping.entities.EmployeeEntity;
import com.example.codingshuttle.jpamapping.jpamapping.repositories.DepartmentRepository;
import com.example.codingshuttle.jpamapping.jpamapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;

    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);

        if (departmentEntity == null || employeeEntity == null) return null;

        departmentEntity.setManager(employeeEntity);
        return departmentRepository.save(departmentEntity);

    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
        if (employeeEntity == null) return null;
        return employeeEntity.getManagedDepartment();

    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        DepartmentEntity department = departmentRepository.findById(departmentId).orElse(null);
        EmployeeEntity worker = employeeRepository.findById(employeeId).orElse(null);

        if (department == null || worker == null) return null;
        worker.setWorkerDepartment(department);
        employeeRepository.save(worker);
        department.getWorkers().add(worker);
        return department;
    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {
        DepartmentEntity department = departmentRepository.findById(departmentId).orElse(null);
        EmployeeEntity freeLancer = employeeRepository.findById(employeeId).orElse(null);

        if (department == null || freeLancer == null) return null;
        freeLancer.getFreelanceEntity().add(department);
        employeeRepository.save(freeLancer);
        department.getFreeLancers().add(freeLancer);
        return department;
    }
}
