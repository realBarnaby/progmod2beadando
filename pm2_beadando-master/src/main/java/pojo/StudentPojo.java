package pojo;

import enum_.Gender;

public class StudentPojo {
    public String name;
    public Integer id;
    public String department;
    public Gender gender;


    public StudentPojo(String name, Integer id, String department, Gender gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
    }
    public StudentPojo()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return this.name + ", " + this.id + ", " + this.department + ", " + this.gender;
    }
}