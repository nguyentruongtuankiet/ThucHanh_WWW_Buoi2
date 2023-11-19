package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends GenericCRUD<Customer> {

    public CustomerRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public Optional<Customer> getCustomerById(long id){
        try {
            return Optional.of(em.find(Customer.class, id));
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

        List<Customer> customerList = customerRepository.getAll(Customer.class);
        for (Customer cus: customerList

             ) {
            System.out.println(cus);

        }
    }
}
