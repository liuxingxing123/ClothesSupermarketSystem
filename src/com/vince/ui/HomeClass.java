package com.vince.ui;

import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.utils.ConsoleTable;

import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-18 14:00
 */
public class HomeClass extends BaseClass {
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
                    buyProducts();
                    flag = false;
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

    private void buyProducts() {
        println("购买");
    }

    private void findOrderById() {
        println("查找订单");
    }

    private void findList() {
        println("查询全部订单");
    }

    private void ShowProducts() {
        ClothesService clothesService = new ClothesServiceImpl();
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
