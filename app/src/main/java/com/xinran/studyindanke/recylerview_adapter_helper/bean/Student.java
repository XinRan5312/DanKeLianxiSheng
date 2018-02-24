package com.xinran.studyindanke.recylerview_adapter_helper.bean;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by houqixin on 2018/2/8.
 */

public class Student implements Serializable{

    private static final long serialVersionUID = 7941432222785934870L;

    public String name;
    public int age;
    public Bitmap icon;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", icon=" + icon +
                '}';
    }
}
