package com.dto;

import java.sql.Date;


public class StudentDTO {
    private int id;
    private String name;
    private Date birthDay;
    private String ClassName;
    private int classId;

    public StudentDTO(int id, String name,Date birthDay , String ClassName,int classId) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.ClassName = ClassName;
        this.classId = classId;
    }

    public StudentDTO() {
    }

    public int getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }
}
