package com.model.entity;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date birthDay;
    private int ClassId;

    public Student(int id, String name, Date birthDay, int classId) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        ClassId = classId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }
}
