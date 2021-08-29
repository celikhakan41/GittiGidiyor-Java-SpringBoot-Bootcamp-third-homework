package dev.patika.thirdhomeworkhakancelik.util;

import dev.patika.thirdhomeworkhakancelik.dao.CourseDao;
import dev.patika.thirdhomeworkhakancelik.dao.InstructorDao;
import dev.patika.thirdhomeworkhakancelik.dao.StudentDao;
import dev.patika.thirdhomeworkhakancelik.models.entities.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.TextUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;


@Component
public class InitializerRunner implements CommandLineRunner {



    private InstructorDao instructorDao;
    private StudentDao studentDao;
    private CourseDao courseDao;

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    public InitializerRunner(InstructorDao instructorDao, StudentDao studentDao, CourseDao courseDao) {
        this.instructorDao = instructorDao;
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }




    @Override
    public void run(String... args) throws Exception {
        //Student records
        Student student1 = new Student("Muhammed Hakan ÇELİK", LocalDate.of(1998,5,9),"Kocaeli","Erkek");
        Student student2 = new Student("İbrahim Sedat Çelik", LocalDate.of(2006,10,25),"Kocaeli","Erkek");
        Student student3 = new Student("Gamze Güler Çelik", LocalDate.of(1999,5,6),"Elazığ","Kadın");
        Student student4 = new Student("Aras Çelik", LocalDate.of(2019,7,4),"Croydon","Erkek");
        Student student5 = new Student("Duru Güler", LocalDate.of(2013,8,1),"Elazığ","Kadın");

        //Course records
        Course veritabaniYonetimi = new Course("Veritabanı Yönetimi","VY311",3);
        Course veriYapilari = new Course("Veri Yapıları","VY211",4);
        Course algoritma = new Course("Algoritma ve Programlama","AG111",5);

        //Instructor records
        Instructor guestResearcher = new GuestResearcher("Ali Sarı","Kocaeli","7745745",12);
        Instructor permanentInstructor1 = new PermanentInstructor("Baki Çelik","İzmit","111122111",2480);
        Instructor permanentInstructor2 = new PermanentInstructor("Osman Küçükoğlu","Gebze","993434439",4480);



        //Student course assignment
        student1.setCourseList(Arrays.asList(veritabaniYonetimi,veriYapilari));
        student2.setCourseList(Arrays.asList(veriYapilari,algoritma));
        student3.setCourseList(Arrays.asList(algoritma));
        student4.setCourseList(Arrays.asList(veriYapilari));
        student5.setCourseList(Arrays.asList(veritabaniYonetimi));

        //Course instructor assignment
        veritabaniYonetimi.setInstructor(guestResearcher);
        veriYapilari.setInstructor(permanentInstructor1);
        algoritma.setInstructor(permanentInstructor2);


        //GuestResearcher course assignment
        guestResearcher.setCourseList(Arrays.asList(algoritma,veritabaniYonetimi));

        //PermanentInstructor course assignment
        permanentInstructor1.setCourseList(Arrays.asList(veriYapilari));
        permanentInstructor2.setCourseList(Arrays.asList(algoritma));




        //Saved entities
        instructorDao.save(guestResearcher);
        instructorDao.save(permanentInstructor1);
        instructorDao.save(permanentInstructor2);
        courseDao.save(veritabaniYonetimi);
        courseDao.save(algoritma);
        courseDao.save(veriYapilari);
        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);
        studentDao.save(student5);



        //Logging Entities
        studentDao.findAll().forEach(student -> logger.info("{}",student));
        courseDao.findAll().forEach(course -> logger.info("Course-> ID:{} Name:{} Code:{} Credit Score:{} Instructor:{}",course.getId(),course.getName(),course.getCode(),course.getCreditScore(),course.getInstructor().getName()));
        instructorDao.getAllInstructors().forEach(instructor -> logger.info("Instructor-> Name:{} Phone Number:{} Address:{}",instructor.getName(),instructor.getPhoneNumber(),instructor.getAddress()));
        logger.info(studentDao.findById(1).toString());
        studentDao.save(new Student("Koray Güney",LocalDate.of(1989,2,11),"İstanbul","Erkek"));
        instructorDao.updateInstructorName(3,"Koray Güney");



    }

}
