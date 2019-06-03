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

    public class Child{

        private String name;

        private String age;

        private String phone;

        private String email;

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setAge(String age){
            this.age = age;
        }
        public String getAge(){
            return this.age;
        }
        public void setPhone(String phone){
            this.phone = phone;
        }
        public String getPhone(){
            return this.phone;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getEmail(){
            return this.email;
        }

    }

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
