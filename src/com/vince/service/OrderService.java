package com.vince.service;

import com.vince.bean.Order;
import com.vince.utils.BussinessException;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 15:10
 */
public interface OrderService {
    public void buyProduct(Order o)throws BussinessException;
    public List<Order> list() throws BussinessException;
    public Order findById(int orderId) throws  BussinessException;
}
