package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface EmployeeService {
  Employee getEmployee(int id);

  Employee createEmployee(Employee employee);

  Employee updateEmployee(int id, Employee emp);

  Void deleteEmployee(int id);
}
