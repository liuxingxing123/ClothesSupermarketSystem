package com.vince.service.impl;

import com.vince.bean.Order;
import com.vince.service.OrderService;
import com.vince.utils.BussinessException;
import com.vince.utils.OrderIO;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 15:11
 */
public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();
    @Override
    public void buyProduct(Order o) throws BussinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BussinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BussinessException {
        return orderIO.findByOrderId(orderId);
    }
}
