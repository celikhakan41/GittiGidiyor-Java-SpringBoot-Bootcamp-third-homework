package dev.patika.thirdhomeworkhakancelik.controller;


import dev.patika.thirdhomeworkhakancelik.dao.StudentDao;
import dev.patika.thirdhomeworkhakancelik.models.entities.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentDao studentDao;


    //private final StudentRepository repository;

    @GetMapping("/index")
    public String showStudentList(Model model){
        model.addAttribute("students",studentDao.findAll());
        return "index";
    }

    @GetMapping("/signup")
    private String showSignupPage(Student student){
        return "addstudent";
    }

}
