package com.yuyang.jsondemo.bean;

/**
 * Author: yuyang
 * Date:2019/6/3 8:13
 */
public class Group {

    private User user;

    private Info info;

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setInfo(Info info){
        this.info = info;
    }
    public Info getInfo(){
        return this.info;
    }

}
