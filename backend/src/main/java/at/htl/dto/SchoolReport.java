package at.htl.dto;

public class SchoolReport {

    String abbreviation;

    int note;

    public SchoolReport() {
    }

    public SchoolReport(String abbreviation, int note) {
        this.abbreviation = abbreviation;
        this.note = note;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
