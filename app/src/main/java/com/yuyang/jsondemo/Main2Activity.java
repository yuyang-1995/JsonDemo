package com.yuyang.jsondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.yuyang.jsondemo.bean.ChildRoot;
import com.yuyang.jsondemo.bean.GroupRoot;
import com.yuyang.jsondemo.bean.MuserRoot;
import com.yuyang.jsondemo.bean.Person;
import com.yuyang.jsondemo.bean.StudentRoot;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    String getjsonstr;
    int id;
    TextView tv_1, tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initValue();

        initView();

        tv_1.setText(getjsonstr + id);

        jiexiJsonStr();
    }

    //对Json字符串进行解析
    private void jiexiJsonStr(){
        if (id == 1){
            parseNoHeaderJArray();
        }else if (id == 2){
            parseHaveHeaderJArray();
        }else if (id == 3){
            parseComplexJArrayByCommon();
        }else if (id == 4){
            parseComplexJArrayByDirect();
        }else if (id == 5){
            try{
               /// parseComplexJArrayByReader();
                testComplexArray();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
  }


    private void testComplexArray() {

        Gson gson = new Gson();
        GroupRoot groupRoot = gson.fromJson(getjsonstr,GroupRoot.class);

        GroupRoot.Group.Info info = groupRoot.getGroup().getInfo();
        System.out.println(info.getAddress()+ "  " + info.getMotto() + " " + info.getPay() + "  " + info.getWork());

        GroupRoot.Group.User user = groupRoot.getGroup().getUser();
        System.out.println(user.getAge() + " " + user.getEmail() + " " + user.getName() + " " + user.getPhone());

    }

    /**
     * 通过JsonReader的方式去解析
     */
    private void parseComplexJArrayByReader() throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(getjsonstr));

        try{
            jsonReader.beginObject();
            String tagName = jsonReader.nextName();

            if (tagName.equals("group")){
                //读这个节点
                readGroup(jsonReader);
            }
            jsonReader.endObject();

        }finally {
            jsonReader.close();
        }

    }

    /**
     * 读group这个节点
     *
     * @param jsonReader JsonReader
     */
    private void readGroup(JsonReader jsonReader) throws IOException{


        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String tagName = jsonReader.nextName();

            if (tagName.equals("user")){
                readUser(jsonReader);

            }else if (tagName.equals("info")){
                readInfo(jsonReader);
            }
        }
        jsonReader.endObject();

    }

    /**
     *读用户其他消息 info节点 Info类
     * @param jsonReader
     */
    private void readInfo(JsonReader jsonReader) throws IOException{

        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String tag = jsonReader.nextName();
            if (tag.equals("address")){
                String address = jsonReader.nextString();
                System.out.print(address + "  ");

            }else if (tag.equals("work")){
                String work = jsonReader.nextString();
                System.out.print(work + "  ");
            }else if (tag.equals("pay")){
                String pay = jsonReader.nextString();
                System.out.print(pay + "  ");
            }else if (tag.equals("motto")){
                String motto = jsonReader.nextString();
                System.out.print(motto + "  ");
            }else {
                jsonReader.skipValue();
            }

        }

        jsonReader.endObject();
    }

    /**
     * 读用户基本消息 user节点  User类
     *
     * @param jsonReader JsonReader
     */
    private void readUser(JsonReader jsonReader) throws IOException{

        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String tag = jsonReader.nextName();
            if (tag.equals("name")){
                String name = jsonReader.nextString();
                System.out.print(name + "  ");
            } else if (tag.equals("age")) {
                String age = jsonReader.nextString();
                System.out.print(age + "  ");
            } else if (tag.equals("phone")) {
                String phone = jsonReader.nextString();
                System.out.print(phone + "  ");
            } else if (tag.equals("email")) {
                String email = jsonReader.nextString();
                System.out.print(email + "  ");
            } else {
                jsonReader.skipValue();//忽略
            }
        }

        jsonReader.endObject();

        }


    /**
     * 有数据头 复杂数据 截取方式
     */
    private void parseComplexJArrayByDirect() {

        List<ChildRoot.Child> childList = new ArrayList<>();

        JsonObject jsonObject = new JsonParser().parse(getjsonstr).getAsJsonObject();

        Gson gson = new Gson();

        //创建JsonArray
        JsonArray jsonArray = jsonObject.getAsJsonArray("child");

        ChildRoot childRoot = gson.fromJson(getjsonstr, ChildRoot.class);

        System.out.println(childRoot.getCode() + "  " + childRoot.getMsg());

        //创建实体类集合
        for (JsonElement jsonElement : jsonArray){

            ChildRoot.Child child = gson.fromJson(jsonElement, ChildRoot.Child.class);

            //条件过滤
            if (Integer.parseInt(child.getAge()) >30){
                childList.add(child);
            }
        }

        //展示
        for(int i = 0;i < childList.size();i++){

            System.out.println(childList.get(i).getName() + " " + childList.get(i).getEmail() + "  "
                    + childList.get(i).getAge() + " " +childList.get(i).getPhone());
        }
    }

    /**
     * 有消息头 复杂数据 常规方式
     */
    private void parseComplexJArrayByCommon() {

        Gson gson = new Gson();

        StudentRoot studentRoot = gson.fromJson(getjsonstr,StudentRoot.class);

        System.out.println(studentRoot.getStudentCode() + " " + studentRoot.getMsg());

        List<StudentRoot.Student> studentList = studentRoot.getStudent();

        //展示
        for(int i = 0;i < studentList.size();i++){

            System.out.println(studentList.get(i).getName() + " " + studentList.get(i).getEmail() + "  "
                    + studentList.get(i).getAge() + " " +studentList.get(i).getPhone());
        }

    }

    /**
     * 解析有数据头的纯数组
     */
    private void parseHaveHeaderJArray() {

        JsonParser jsonParser = new JsonParser();

        //先转JsonObject
        JsonObject jsonObject = jsonParser.parse(getjsonstr).getAsJsonObject();

        //再转JsonArray 加上数据头，即Javabean的类型
        JsonArray jsonArray = jsonObject.getAsJsonArray("muser");

        Gson gson = new Gson();

        ArrayList<MuserRoot.Muser> musers = new ArrayList<>();

        //
        for (JsonElement jsonElement : jsonArray){
            //
            MuserRoot.Muser muser = gson.fromJson(jsonElement, new TypeToken<MuserRoot.Muser>() {}.getType());
            musers.add(muser);

        }

        //展示
        for(int i = 0;i < musers.size();i++){
            System.out.println(musers.get(i).getName() + " " + musers.get(i).getEmail() + "  "
                    + musers.get(i).getAge() + " " +musers.get(i).getPhone());
        }
 }

    /**
     * 解析没有数据头的纯数组
     */
    private void parseNoHeaderJArray() {
        //Json的解析类对象
        JsonParser jsonParser = new JsonParser();
        //将Json字符串转成一个JsonArray对象
        JsonArray jsonArray = jsonParser.parse(getjsonstr).getAsJsonArray();

        Gson gson = new Gson();

        ArrayList<Person> personArrayList = new ArrayList<>();

        //遍历JsonArray对象，通过gson解析JsonArray中的元素JsonElement 并将其解析结果赋值给实体类，将实体类添加到实体集合中
        for (JsonElement element : jsonArray){
            //使用Gson，直接转成Bean对象
            Person person = gson.fromJson(element, Person.class);
            personArrayList.add(person);
        }

        //展示
        for(int i = 0;i < personArrayList.size();i++){
            System.out.println(personArrayList.get(i).getName() + " " + personArrayList.get(i).getEmail() + "  "
                + personArrayList.get(i).getAge() + " " +personArrayList.get(i).getPhone());
        }

    }

    private void initView() {

        tv_1 = findViewById(R.id.tv_json);
        tv_2 = findViewById(R.id.tv_jiexijson);

    }

    private void initValue() {
        Intent intent = getIntent();
        getjsonstr = intent.getStringExtra("jsonstr");
        id = intent.getIntExtra("id",0);


    }
}
