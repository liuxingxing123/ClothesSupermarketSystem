package com.vince.service.impl;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.utils.BussinessException;
import com.vince.utils.EmptyUtils;
import com.vince.utils.UserIO;
import sun.invoke.empty.Empty;

/**
 * @author liuxingxing
 * @date 2019-06-17 21:42
 */
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BussinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();


        return user;
    }

    @Override
    public User login(String username, String password) throws BussinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BussinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BussinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username, password);

        return user;
    }
}
