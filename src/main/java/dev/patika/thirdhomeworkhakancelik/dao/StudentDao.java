package dev.patika.thirdhomeworkhakancelik.dao;

import dev.patika.thirdhomeworkhakancelik.models.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student,Integer> {
    @Query("from Student ")
    List<Student> getAllStudents();

    @Modifying
    @Transactional
    @Query("update Student i set i.name = :name where i.id = :id")
    void updateStudentName(int id,String name);

}
