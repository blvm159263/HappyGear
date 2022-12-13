package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.OrderDetail;
import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.model.dto.CartItemDto;
import com.notimplement.happygear.model.dto.OrderDetailDto;
import com.notimplement.happygear.model.mapper.OrderDetailMapper;
import com.notimplement.happygear.repositories.OrderDetailRepository;
import com.notimplement.happygear.repositories.OrderRepository;
import com.notimplement.happygear.repositories.ProductRepository;
import com.notimplement.happygear.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderDetailDto> getAllOrderDetailDto() {
        return orderDetailRepository.findAll()
                .stream().map(OrderDetailMapper::toOrderDetailDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetailDto getByDetailId(Integer id) {
        OrderDetail orderDetail = orderDetailRepository.findByDetailId(id);
        return OrderDetailMapper.toOrderDetailDto(orderDetail);
    }

    @Override
    public List<OrderDetailDto> getAllByOrderId(Integer id) {
        return orderDetailRepository.findAllByOrderId(id)
                .stream().map(OrderDetailMapper::toOrderDetailDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailDto> getAllByProductId(Integer id) {
        return orderDetailRepository.findAllByProductId(id)
                .stream().map(OrderDetailMapper::toOrderDetailDto).collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto create(OrderDetailDto orderDetailDto) {
        if (orderDetailDto != null) {
            OrderDetail od = toOrderDetail(orderDetailDto);
            orderDetailRepository.save(od);
            return OrderDetailMapper.toOrderDetailDto(od);
        }
        return null;
    }

    @Override
    public OrderDetailDto update(OrderDetailDto orderDetailDto) {
        if (orderDetailDto != null) {
            OrderDetail od = toOrderDetail(orderDetailDto);
            orderDetailRepository.save(od);
            return OrderDetailMapper.toOrderDetailDto(od);
        }
        return null;
    }

    @Override
    public OrderDetailDto delete(Integer id) {
        OrderDetail od = orderDetailRepository.findByDetailId(id);
        od.setStatus(false);
        return OrderDetailMapper.toOrderDetailDto(orderDetailRepository.save(od));
    }

    @Override
    public Double getCartAmount(List<CartItemDto> list) {
        Double totalCartAmount = 0d;
        Double singleCartAmount = 0d;
        int availableQuantity = 0;
        for(var o : list){
            int productId = o.getProductId();
            Product product = productRepository.findByProductId(productId);
            if(product!=null){
                if(product.getQuantity() < o.getQuantity()){
                    log.info("Dont have enough quantity of product");
                    return 0d;
                }
                else{
                    singleCartAmount = o.getQuantity() * product.getPrice();
                    availableQuantity = product.getQuantity() - o.getQuantity();
                }
                totalCartAmount += singleCartAmount;
                product.setQuantity(availableQuantity);
                productRepository.save(product);
            }
        }
        return totalCartAmount;
    }

    private OrderDetail toOrderDetail(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(orderDetailDto.getDetailId());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setStatus(orderDetailDto.getStatus());
        orderDetail.setOrder(orderRepository.findByOrderId(orderDetailDto.getOrderId()));
        orderDetail.setOrderdetailProduct(productRepository.findByProductId(orderDetailDto.getProductId()));
        return orderDetail;
    }
}
