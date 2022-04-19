package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Exam extends PanacheEntity implements Serializable {
    //Prüfungen

    @ManyToOne
    public Student student;

    @ManyToOne
    public Subject subject;

    public LocalDateTime date;

    public int note;


    public Exam() {}

    public Exam(Student student, Subject subject, LocalDateTime date, int note) {
        this.student = student;
        this.subject = subject;
        this.date = date;
        this.note = note;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
