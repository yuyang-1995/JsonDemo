package com.yuyang.jsondemo.bean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/4 0:34
 */
public class TestToJson {

   private  String name;

   private int id;

   private List<InnerClass> innerClassList;

   public class InnerClass{

       public String innerName;

       public int inId;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<InnerClass> getInnerClassList() {
        return innerClassList;
    }

    public void setInnerClassList(List<InnerClass> innerClassList) {
        this.innerClassList = innerClassList;
    }
}
