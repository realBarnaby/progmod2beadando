package service;

import enum_.Gender;
import pojo.StudentPojo;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
@Service
public class StudentServiceImplementation implements StudentService {

    public static ArrayList<StudentPojo> XML(String filepath) {
        ArrayList<StudentPojo> list = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(filepath);
            Element rootElement = doc.getDocumentElement();
            NodeList childNodeList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodeList.getLength(); i++) {
                node = childNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childnodelist = node.getChildNodes();
                    String name = "", id = "", department = "", gender = "";
                    for (int j = 0; j < childnodelist.getLength(); j++) {
                        Node childnode = childnodelist.item(j);
                        if (childnode.getNodeType() == Node.ELEMENT_NODE) {
                            switch (childnode.getNodeName()) {
                                case "name" -> name = childnode.getTextContent();
                                case "id" -> id = childnode.getTextContent();
                                case "deparment" -> department = childnode.getTextContent();
                                case "gender" -> gender = childnode.getTextContent();
                            }
                        }
                    }
                    list.add(new StudentPojo(name, Integer.parseInt(id), department, Gender.valueOf(gender)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public StudentPojo searchName(String name){
        StudentPojo result = new StudentPojo();
        for(StudentPojo x : XML("src/main/resources/xml/data.xml")){
            if(x.name.equals(name)){
                result=x;
            }
        }
        return result;
    }
    @Override
    public ArrayList<String> XML() {
        return null;
    }
}