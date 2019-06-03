package com.yuyang.jsondemo.bean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/3 7:34
 */
public class ChildRoot {

    private int code;

    private String msg;

    private List<Child> child ;

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setChild(List<Child> child){
        this.child = child;
    }
    public List<Child> getChild(){
        return this.child;
    }

}
