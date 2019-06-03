package com.yuyang.jsondemo.bean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/2 23:11
 */
public class MuserRoot {

    //{
    //  "muser": [
    //    {
    //      "name": "zhangsan",
    //      "age": "10",
    //      "phone": "11111",
    //      "email": "11111@11.com"
    //    },
    //    {
    //      "name": "lisi",
    //      "age": "20",
    //      "phone": "22222",
    //      "email": "22222@22.com"
    //    },
    //    {
    //      "name": "wangwu",
    //      "age": "30",
    //      "phone": "33333",
    //      "email": "33333@33.com"
    //    },
    //    {
    //      "name": "qianliu",
    //      "age": "40",
    //      "phone": "44444",
    //      "email": "44444@44.com"
    //    },
    //    {
    //      "name": "zhaoqi",
    //      "age": "50",
    //      "phone": "55555",
    //      "email": "55555@55.com"
    //    }
    //  ]
    //}

    private List<Muser> muser;

    public class Muser{

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

    public void setMuser(List<Muser> muser){
        this.muser = muser;
    }


    public List<Muser> getMuser(){
        return this.muser;
    }
}
