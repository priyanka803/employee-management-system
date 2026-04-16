package com.example.employee.services.impl;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   // private static List<Employee> employees = new ArrayList<>();

    private final EmployeeDao employeeDao;
//    static {
//        employees.add(new Employee(1, "Ram", 25, "Delhi"));
//        employees.add(new Employee(2, "Shivam", 30, "Mumbai"));
//    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
      //  return employees;
       return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
//        for (Employee emp : employees) {
//            if (emp.getId() == id) {
//                return emp;
//            }
//        }
//        return null;
        return employeeDao.getById(id);
    }

    @Override
    public void saveOrUpdateEmployee(Employee emp) {
        employeeDao.saveOrUpdateEmployee(emp);
        //employees.add(emp);
    }
}
