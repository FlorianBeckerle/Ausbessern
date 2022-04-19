package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.ws.rs.GET;
import java.io.Serializable;

@Entity
public class Subject extends PanacheEntityBase implements Serializable {
    //Gegenstände

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String abbreviation;

    String description;

    public Subject() {}

    public Subject(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
