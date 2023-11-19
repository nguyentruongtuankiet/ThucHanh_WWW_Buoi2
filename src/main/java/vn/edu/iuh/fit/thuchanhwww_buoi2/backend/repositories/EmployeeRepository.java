package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;


import jakarta.persistence.EntityTransaction;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Employee;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository extends GenericCRUD<Employee> {
    public EmployeeRepository() {
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public Optional<Employee> getEmployeeById(long id) {
        try {
            return Optional.of(em.find(Employee.class, id));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }

    public List<Employee> getAll() {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from Employee";
            System.out.println("bahsvbsdoiẠDOIjciusacbib");
            List<Employee> rl = em.createNativeQuery(sql, Employee.class).getResultList();
            tr.commit();
            return rl;
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Employee> getActiveEmployee() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }


}
