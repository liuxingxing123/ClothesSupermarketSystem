package com.vince.service;

import com.vince.bean.User;
import com.vince.utils.BussinessException;

/**
 * @author liuxingxing
 * @date 2019-06-17 21:40
 */
public interface UserService {
    public User register(User user) throws BussinessException;
    public User login(String username,String password) throws BussinessException;
}
