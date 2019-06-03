package com.yuyang.jsondemo.bean;

/**
 * Author: yuyang
 * Date:2019/6/3 8:14
 */
public class GroupRoot {

    private Group group;

    public class Group{

        private User user;

        private Info info;


        public class User{

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

        public class Info{

            private String address;

            private String work;

            private String pay;

            private String motto;

            public void setAddress(String address){
                this.address = address;
            }

            public String getAddress(){
                return this.address;
            }

            public void setWork(String work){
                this.work = work;
            }

            public String getWork(){
                return this.work;
            }

            public void setPay(String pay){
                this.pay = pay;
            }

            public String getPay(){
                return this.pay;
            }

            public void setMotto(String motto){
                this.motto = motto;
            }

            public String getMotto(){
                return this.motto;
            }

        }


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

    public void setGroup(Group group){
        this.group = group;
    }

    public Group getGroup(){
        return this.group;
    }

}
