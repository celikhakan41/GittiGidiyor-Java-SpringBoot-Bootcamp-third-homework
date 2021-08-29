package dev.patika.thirdhomeworkhakancelik.service;


import dev.patika.thirdhomeworkhakancelik.dao.StudentDao;
import dev.patika.thirdhomeworkhakancelik.models.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  {
    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public Student createStudent(Student student){
        return studentDao.save(student);
    }
}
