package com.advanta.dao.model;
// Generated Feb 13, 2018 11:43:29 AM by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private int id;
     private String fullname;
     private String username;
     private String password;

    public Users() {
    }

    public Users(String fullname, String username, String password) {
       this.fullname = fullname;
       this.username = username;
       this.password = password;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

