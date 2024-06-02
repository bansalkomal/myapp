package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Emp> getAllEmps() {
        return empRepository.findAll();
    }

    public Emp getEmpById(Long empId) {
        return empRepository.findById(empId).orElse(null);
    }

    public Emp saveEmp(Emp emp) {
        return empRepository.save(emp);
    }

    public void deleteEmp(Long empId) {
        empRepository.deleteById(empId);
    }
}