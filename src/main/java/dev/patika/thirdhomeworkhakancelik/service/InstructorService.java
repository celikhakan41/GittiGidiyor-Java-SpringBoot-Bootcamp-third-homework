package dev.patika.thirdhomeworkhakancelik.service;

import dev.patika.thirdhomeworkhakancelik.dao.InstructorDao;
import dev.patika.thirdhomeworkhakancelik.models.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;

public class InstructorService {

    private InstructorDao instructorDao;

    @Autowired
    public InstructorService(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    public Instructor createInstructor(Instructor instructor){
        return instructorDao.save(instructor);
    }
}
