package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


  @Autowired
  EmployeeService employeeService;

  @GetMapping("/employee/{id}")
  public Employee getEmployee(@PathVariable int employeeId) {

    return employeeService.getEmployee(employeeId);
  }


  @PostMapping("/create")
  public Employee createEmployee(@RequestBody Employee employee){
    return employeeService.createEmployee(employee);
  }

  @PutMapping("/update/{id}")
  public Employee updateEmployee(@PathVariable int id,@RequestBody Employee emp){
    return employeeService.updateEmployee(id,emp);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }



}
