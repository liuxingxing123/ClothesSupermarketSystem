package com.vince.service.impl;

import com.vince.bean.Order;
import com.vince.service.OrderService;
import com.vince.utils.BussinessException;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 15:11
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void buyProduct(Order o) throws BussinessException {

    }

    @Override
    public List<Order> list() throws BussinessException {
        return null;
    }

    @Override
    public Order findById(int orderId) throws BussinessException {
        return null;
    }
}
