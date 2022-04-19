package at.htl.repository;

import at.htl.model.Student;
import io.quarkus.hibernate.orm.panache.Panache;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StudentRepository {

    public static void createStudent(Student student){
        Panache.getEntityManager().persist(student);
    }



}
