/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advant.user;

import com.atvanta.util.Databases;
import com.atvanta.util.*;
import com.atvanta.model.*;
import java.util.List;
import com.advanta.dao.model.Users;
import com.advanta.dao.model.Product;
import com.advanta.security.*;
/**
 *
 * @author Levi
 */
public class Access {
    OperationsDal ops;

    public Access() {
        ops = OperationsDalImpl.getInstance(Databases.PRODUCTS);
    }
     public  void logoutUser(String username) { 
         Access access = new Access();
         Users user = access.getUser(username);
         ops.delete(user);
    }
     public boolean handleLogin(String username, String password) {
         boolean loggedIn = false;
        CoreQuery coreQuery = new CoreQuery("from Users where username =:username and password =:password", true);
        coreQuery.addParam("username", username); 
        coreQuery.addParam("password",password );//Encode.EncodeUserPassword(username,password) ); 
        List users = ops.fetch(coreQuery);
        if(users.size() > 0){
        loggedIn = true;
        }
        return loggedIn;
    }
     public Users getUser(String username) {
        CoreQuery coreQuery = new CoreQuery("from Users where username =:username", true);
        coreQuery.addParam("username", username);  
        List users = ops.fetch(coreQuery);
        return (Users) users.get(0);
    } 
     public  void createUser(UserModel userModel) {
         Users user = new Users();   
     user.setFullname(userModel.getFullname());
     //user.setPassword(Encode.EncodeUserPassword(userModel.getUsername() ,userModel.getPassword()));
      user.setPassword(userModel.getPassword());
     user.setUsername(userModel.getUsername());
     ops.save(user);
     }
     public  void updateUser(UserModel userModel) {
         Users user = new Users();   
     user.setFullname(userModel.getFullname());
     user.setId(userModel.getId());
     user.setPassword(userModel.getPassword());
     //user.setPassword(Encode.EncodeUserPassword(userModel.getUsername() ,userModel.getPassword()));
     user.setUsername(userModel.getUsername());
     ops.save(user);
     }
}
