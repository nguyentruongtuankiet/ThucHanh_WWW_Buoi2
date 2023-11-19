package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.OrderDetail;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailServices {
    @Inject
    private OrderDetailRepository orderDetailRepository;

    public boolean add(OrderDetail orderDetail){
        return orderDetailRepository.add(orderDetail);
    }

    public List<OrderDetail> getAll(){
        return orderDetailRepository.getAll(OrderDetail.class);
    }
}
