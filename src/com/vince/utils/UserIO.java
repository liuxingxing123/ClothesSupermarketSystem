package com.vince.utils;

import com.vince.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxingxing
 * @date 2019-06-17 21:45
 */
public class UserIO {
    private static List<User> users = new ArrayList<>();
    private static final String USER_FILE = "user.obj";
    
    public boolean writeUsers() throws BussinessException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
            return true;
        } catch (IOException e) {
            throw new BussinessException("io.write.error");
        }


    }
    
    public boolean readUsers() throws BussinessException{
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new BussinessException("io.read.error");
        }
    }

    public void add(User user){
        user.setId(users.size()+1);
        users.add(user);
    }

    public User findByUsernameAndPassword(String username,String password){
        for(User u:users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
