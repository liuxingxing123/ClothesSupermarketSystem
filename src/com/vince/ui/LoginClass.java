package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BussinessException;

/**
 * @author liuxingxing
 * @date 2019-06-17 22:06
 */
public class LoginClass extends BaseClass {

    public void login() throws BussinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if(user!=null){
            currUser = user;
        }else{
            throw new BussinessException("login.error");
        }



    }
}
