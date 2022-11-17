package service;

import pojo.StudentPojo;

import java.util.ArrayList;

public interface StudentService {
    StudentPojo searchName(String name);

    ArrayList<String> XML();
}