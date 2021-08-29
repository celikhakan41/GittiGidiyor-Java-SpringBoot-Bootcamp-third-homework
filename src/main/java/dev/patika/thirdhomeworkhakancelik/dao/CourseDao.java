package dev.patika.thirdhomeworkhakancelik.dao;

import dev.patika.thirdhomeworkhakancelik.models.entities.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {

    @Query("from Course ")
    List<Course> getAllCourses();

    @Modifying
    @Transactional
    @Query("update Course i set i.name = :name where i.id = :id")
    void updateCourseName(int id,String name);


}
