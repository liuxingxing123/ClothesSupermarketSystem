package com.vince.ui;

import com.vince.utils.BussinessException;
import com.vince.utils.UserIO;

/**
 * @author liuxingxing
 * @date 2019-06-17 21:24
 */
public class WelcomeClass extends BaseClass {

    public void start(){
        println(getString("info.welcome"));
        UserIO users = new UserIO();
        users.readUsers();

        boolean flag = true;
        while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch(select){
                case "1":
                    try {
                        new LoginClass().login();
                        flag = false;
                        println(getString("login.success"));
                    } catch (BussinessException e) {
                        println(getString(e.getMessage()));
                    }

                    break;
                case "2":
                    try {
                        new RegisterClass().register();
                        println(getString("reg.success"));
                        flag = false;
                    } catch (BussinessException e) {
                        println(getString("reg.error"));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }
}
