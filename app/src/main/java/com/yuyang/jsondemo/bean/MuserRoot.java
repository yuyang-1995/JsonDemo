package com.yuyang.jsondemo.bean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/2 23:11
 */
public class MuserRoot {

    private List<Muser> muser ;

    public void setMuser(List<Muser> muser){
        this.muser = muser;
    }
    public List<Muser> getMuser(){
        return this.muser;
    }
}
