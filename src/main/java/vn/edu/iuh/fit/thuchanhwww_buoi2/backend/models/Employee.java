package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.*;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.converters.EmployeeStatusConverter;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.enums.EmployeeStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
@NamedQueries({
        //@NamedQuery(name = "Employee.getAll", query = "FROM Employee "),
        @NamedQuery(name = "Employee.updateStatus", query = "UPDATE Employee  SET status = :status WHERE id = :id"),
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e WHERE e.status = ?1"),
})
public class Employee {
    //employee (emp_id, full_name, dob, email, phone, address, status)
    @Id
    @Column(name = "emp_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(columnDefinition = "datetime(6)")
    private LocalDate dob;

    private String email;

    @Column(columnDefinition = "varchar(15)")
    private String phone;

    private String address;
    @Convert(converter = EmployeeStatusConverter.class)
    @Column(columnDefinition = "INT(11)")
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    @JoinColumn
    @JsonManagedReference
    private List<Order> lstOrder;

    public Employee() {
    }

    public Employee(long id, String fullName, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee(String fullName, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }





    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
