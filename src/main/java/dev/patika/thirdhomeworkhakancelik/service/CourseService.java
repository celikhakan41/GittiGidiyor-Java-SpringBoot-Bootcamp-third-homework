package dev.patika.thirdhomeworkhakancelik.service;

import dev.patika.thirdhomeworkhakancelik.dao.CourseDao;
import dev.patika.thirdhomeworkhakancelik.models.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseDao courseDao;

    @Autowired
    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Course createCourse(Course course){
        return courseDao.save(course);
    }
}
