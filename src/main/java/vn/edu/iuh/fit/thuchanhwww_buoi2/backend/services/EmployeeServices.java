package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;


import jakarta.inject.Inject;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Employee;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.ProductPriceRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    public EmployeeServices() {
        this.employeeRepository = new EmployeeRepository();
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.getEmployeeById(id);
    }

    public boolean add(Employee customer) {
        return employeeRepository.add(customer);
    }

    public boolean update(Employee customer) {
        return employeeRepository.update(customer);
    }

    public boolean remove(long id) {
        return employeeRepository.remove(Employee.class, id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public List<Employee> getActiveEmployee() {
        return employeeRepository.getActiveEmployee();
    }
}
