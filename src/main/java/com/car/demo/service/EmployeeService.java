package com.car.demo.service;

import com.car.demo.model.Book;
import com.car.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final Map<Long, Employee> employees = new HashMap<>();

    static {
        Employee e1=new Employee();
        e1.setId(1l);
        e1.setName("Ram");
        e1.setSalary(1000);

        Employee e2=new Employee();
        e2.setId(2l);
        e2.setName("HI");
        e2.setSalary(200);

//        E b3=new Book();
//        b3.setId(3l);
//        b3.setTitle("Hello");
//        b3.setAuthor("XYZ");
//
//        Book b4=new Book();
//        b4.setId(4l);
//        b4.setTitle("Hey");
//        b4.setAuthor("XYZ");

        employees.put(e1.getId(),e1);
        employees.put(e2.getId(), e2);
//        books.put(b3.getId(), b3);
//        books.put(b4.getId(), b4);


    }
    public List<Employee> getAllEmployees() {
        Collection<Employee> bookCollection=employees.values();
        return bookCollection.stream().toList();
    }

    public Employee createEmployee(Employee employee)
    {
        employees.put(employee.getId(), employee);
        return employee;
    }

    public void deleteEmployee(Long id) {
       employees.remove(id);
    }

    public Employee getEmployee(Long id) {

        return employees.get (id);
//       return (Employee) employees;


    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        employees.put(id,employeeDetails);
        return employees.get(id);
    }
}
