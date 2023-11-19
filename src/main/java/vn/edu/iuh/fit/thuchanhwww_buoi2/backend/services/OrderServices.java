package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Order;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.OrderRepository;

import java.util.List;

public class OrderServices {
    @Inject
    private OrderRepository orderRepository;
    public boolean add(Order order){
        return orderRepository.add(order);
    }

    public List<Order> getAll(){
        return orderRepository.getAll(Order.class);
    }
}
