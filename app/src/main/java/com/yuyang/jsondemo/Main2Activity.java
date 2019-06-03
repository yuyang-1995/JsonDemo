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
import com.yuyang.jsondemo.bean.Child;
import com.yuyang.jsondemo.bean.Muser;
import com.yuyang.jsondemo.bean.Person;
import com.yuyang.jsondemo.bean.Student;
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
                parseComplexJArrayByReader();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
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

                readGroup(jsonReader);
            }

        }finally {
            jsonReader.close();
        }

    }

    private void readGroup(JsonReader jsonReader) throws IOException{

        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String tagName = jsonReader.nextName();
            if (tagName.equals("user")){
                readUser(jsonReader);
            }
        }

    }

    private void readUser(JsonReader jsonReader) {
    }

    /**
     * 有数据头 复杂数据 截取方式
     */
    private void parseComplexJArrayByDirect() {

        List<Child> childList = new ArrayList<>();

        JsonObject jsonObject = new JsonParser().parse(getjsonstr).getAsJsonObject();

        Gson gson = new Gson();

        //创建JsonArray
        JsonArray jsonArray = jsonObject.getAsJsonArray("child");

        //创建实体类集合
        for (JsonElement jsonElement : jsonArray){

            Child child = gson.fromJson(jsonElement,Child.class);

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

        List<Student> studentList = studentRoot.getStudent();

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
        //再转JsonArray 加上数据头
        JsonArray jsonArray = jsonObject.getAsJsonArray("muser");

        Gson gson = new Gson();
        ArrayList<Muser> musers = new ArrayList<>();

        //
        for (JsonElement jsonElement : jsonArray){
            //
            Muser muser = gson.fromJson(jsonElement, new TypeToken<Muser>() {}.getType());
            musers.add(muser);

        }

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
