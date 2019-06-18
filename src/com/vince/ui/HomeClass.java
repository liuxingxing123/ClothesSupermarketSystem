package com.vince.ui;

import com.vince.bean.Clothes;
import com.vince.bean.Order;
import com.vince.bean.OrderItem;
import com.vince.service.ClothesService;
import com.vince.service.OrderService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.service.impl.OrderServiceImpl;
import com.vince.utils.BussinessException;
import com.vince.utils.ConsoleTable;
import com.vince.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 14:00
 */
public class HomeClass extends BaseClass {
    private OrderService orderService = new OrderServiceImpl();
    private ClothesService clothesService = new ClothesServiceImpl();

    public void show(){
        ShowProducts();
        println("welcome:"+currUser.getUsername());
        boolean flag = true;
        while(flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch(select){
                case "1"://查询全部订单
                    findList();
                    flag = false;
                    break;
                case "2"://查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3"://购买
                    try {
                        buyProducts();
                        flag = false;
                    } catch (BussinessException e) {
                        println(e.getMessage());
                    }
                    break;
                case "0"://退出
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    //购买商品
    private void buyProducts() throws BussinessException {
        //生成订单
        boolean flag = true;
        int count=1;
        float sum=0.0F;//订单总金额
        Order order = new Order();//生成的订单
        while(flag){
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            int num = Integer.parseInt(shoppingNum);
            Clothes clothes = clothesService.findById(id);
            OrderItem orderItem = new OrderItem();
            if(num>clothes.getNum()){
                throw new BussinessException("product.num.error");
            }
            //一条订单明细
            clothes.setNum(clothes.getNum()-num);//商品买了之后库存减少
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum((num));
            orderItem.setSum(clothes.getPrice()*num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);

            order.getOrderItemList().add(orderItem);

            println(getString("product.buy.continue"));
            String isbuy = input.nextLine();
            switch (isbuy){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        show();
    }

    private void findOrderById() {
        println("查找订单");
    }

    private void findList() {
        println("查询全部订单");
    }

    private void ShowProducts() {
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");
        for(Clothes c:list){
            t.appendRow();
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }

        println(t.toString());
    }
}
