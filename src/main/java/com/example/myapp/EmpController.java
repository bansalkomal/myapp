package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
//    @Autowired
//    private EmpRepository empRepository;
//
//    @GetMapping
//    public List<Emp> getAllEmps() {
//        return empRepository.findAll();
//    }

    @Autowired
    private EmpService empService;

    @GetMapping
    public List<Emp> getAllEmps() {
        return empService.getAllEmps();
    }

    @GetMapping("/{id}")
    public Emp getEmpById(@PathVariable("id") Long empId) {
        return empService.getEmpById(empId);
    }

    @PostMapping
    public Emp createEmp(@RequestBody Emp emp) {
        return empService.saveEmp(emp);
    }

    @PutMapping("/{id}")
    public Emp updateEmp(@PathVariable("id") Long empId, @RequestBody Emp empDetails) {
        Emp emp = empService.getEmpById(empId);
        if (emp != null) {
            emp.setEmpName(empDetails.getEmpName());
            emp.setEmpSalary(empDetails.getEmpSalary());
            emp.setEmpDepartment(empDetails.getEmpDepartment());
            return empService.saveEmp(emp);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable("id") Long empId) {
        empService.deleteEmp(empId);
    }

    @GetMapping("/stress")
    public int generateStress() {
        int counter = 0;
        for (int i = 0; i <= 50000000; i++) {
            counter += i;
        }
        return counter;
    }
}
