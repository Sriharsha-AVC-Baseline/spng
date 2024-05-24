package com.example.demo.controller;

import com.example.demo.Employee;
import com.example.demo.EmployeeNotFoundException;
import com.example.demo.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    public List<Employee> employees = new ArrayList<>();



    @GetMapping("/fetch")
    public List<Employee> getEmployee()
    {
        employees.add(new Employee(1,"Arun","Manager"));
        employees.add(new Employee(2,"Varun","Lead"));
        employees.add(new Employee(3,"Rocky","Executive"));
        return employees;
    }

    @GetMapping("/fetch/{id}")
    public Employee getEmployeeWithId(@PathVariable("id") int id)
    {

        if(id > employees.size()-1 || id < 0)
        {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return employees.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(EmployeeNotFoundException e)
    {
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(HttpStatus.NOT_FOUND.ordinal());
        response.setMessage(e.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }




}
