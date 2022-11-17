package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.StudentPojo;
import service.StudentServiceImplementation;

import java.util.ArrayList;

@RestController
public class Controller {
    private StudentServiceImplementation service;

    @RequestMapping(path = "kiiratas", method = RequestMethod.GET)
    public ArrayList<StudentPojo> getStudentList() {
        return service.XML("src/main/resources/xml/data.xml");
    }

}
