package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public Employee getEmployee(int id){
    return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("employee not found"));

  }

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(int id, Employee emp) {

    Optional<Employee> employee = employeeRepository.findById(id);
    if(employee.isPresent()){
      Employee newEmployee = new Employee();
     newEmployee.setId(emp.getId());
      newEmployee.setName(emp.getName());
      newEmployee.setDepartment(emp.getDepartment());
      return employeeRepository.save(newEmployee);
    }
    throw new RuntimeException("employee not found");
  }

  @Override
  public Void deleteEmployee(int id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    if(employee.isPresent()){
      employeeRepository.delete(employee.get());
    }
    return null;
  }


}
