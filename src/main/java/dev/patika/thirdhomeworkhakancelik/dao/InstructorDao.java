package dev.patika.thirdhomeworkhakancelik.dao;


import dev.patika.thirdhomeworkhakancelik.models.entities.Instructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InstructorDao extends CrudRepository<Instructor,Integer> {

    @Query("from Instructor")
    List<Instructor> getAllInstructors();

    @Modifying
    @Transactional
    @Query("update Instructor i set i.name = :name where i.id = :id")
    void updateInstructorName(int id,String name);



}
