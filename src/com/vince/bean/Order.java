package com.vince.bean;

import com.vince.utils.orderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 * @author liuxingxing
 * @date 2019-06-17 20:31
 */
public class Order implements Serializable {
    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String createDate;
    private float sum;//总金额
    private orderStatusType status = orderStatusType.UNPAID;
    private int userId;

    public Order() {
    }

    public Order(int orderId, List<OrderItem> orderItemList, String createDate, float sum, orderStatusType status, int userId) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
        this.createDate = createDate;
        this.sum = sum;
        this.status = status;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public orderStatusType getStatus() {
        return status;
    }

    public void setStatus(orderStatusType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItemList=" + orderItemList +
                ", createDate='" + createDate + '\'' +
                ", sum=" + sum +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
