package com.yuyang.jsondemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/2 23:39
 */
public class StudentRoot {

    @SerializedName("code")
    private int studentCode;

    private String msg;

    private List<Student> student ;

    public class Student{

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

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
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
