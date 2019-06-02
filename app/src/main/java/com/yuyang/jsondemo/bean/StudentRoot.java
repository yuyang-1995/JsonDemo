package com.yuyang.jsondemo.bean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/2 23:39
 */
public class StudentRoot {

    private int code;

    private String msg;

    private List<Student> student ;

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
    public void setStudent(List<Student> student){
        this.student = student;
    }
    public List<Student> getStudent(){
        return this.student;
    }
}
