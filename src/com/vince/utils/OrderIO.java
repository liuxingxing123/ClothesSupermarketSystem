package com.vince.utils;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.vince.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 14:58
 */
public class OrderIO {
    private static List<Order> orders = new ArrayList<>();
    private static final String ORDER_FILE = "order.obj";
    public void add(Order order) throws  BussinessException{
        orders.add(order);
    }

    public List<Order> list() throws  BussinessException{
        return orders;
    }

    public Order findByOrderId(int orderId) throws  BussinessException{
        Order order = null;
        int old;
        for(Order o :orders){
            old = o.getOrderId();
            if(old == orderId){
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean writeOrders(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean readOrders(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
             orders = (List<Order>) in.readObject();
             in.close();
             return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
