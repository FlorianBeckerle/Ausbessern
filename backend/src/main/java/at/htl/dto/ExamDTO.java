package at.htl.dto;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class ExamDTO {
    public String firstname;
    public String lastname;

    public String subjectDescription;

    public LocalDateTime date;

    public int note;

    public ExamDTO(){}

    public ExamDTO(String firstname, String lastname, String subjectDescription, LocalDateTime date, int note) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subjectDescription = subjectDescription;
        this.date = date;
        this.note = note;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
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
