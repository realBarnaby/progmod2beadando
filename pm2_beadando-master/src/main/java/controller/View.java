package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pojo.StudentPojo;
import service.StudentServiceImplementation;

@RestController
public class View
{
    StudentServiceImplementation studentServiceImplementation =new StudentServiceImplementation();
    @RequestMapping(path = "fooldal", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("fooldal");
        return view;
    }
    @RequestMapping(path = "kereses", method = RequestMethod.POST)
    public ModelAndView favorite(String memo) {
        ModelAndView view = new ModelAndView("kereses");
        StudentPojo studentPojo = studentServiceImplementation.searchName(memo);
        try{
            view.addObject("name", studentPojo.name);
            view.addObject("id", studentPojo.id);
            view.addObject("department", studentPojo.department);
            view.addObject("gender", studentPojo.gender.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
