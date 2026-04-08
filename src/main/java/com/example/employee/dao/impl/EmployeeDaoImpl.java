package com.example.employee.dao.impl;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.model.Employee;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Employee getById(int id){
       return sessionFactory.getCurrentSession().find(Employee.class,id);
    }
    @Override
    public List<Employee> getAll(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee e order by e.id asc", Employee.class).list();
    }


    @Override
    @Transactional
    public void saveEmployee(Employee employee){
        sessionFactory.getCurrentSession().merge(employee);
    }
}
