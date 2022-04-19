package at.htl.repository;

import at.htl.dto.ExamDTO;
import at.htl.dto.SchoolReport;
import at.htl.model.Exam;
import at.htl.model.Student;
import at.htl.model.Subject;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ExamRepository implements PanacheRepository<Exam> {

    //TODO: Prüfung eintragen (Schüler: Vorname, Nachname; Gegenstand (als Bezeichnung); Note)
    public static void createExam(ExamDTO examDTO){
        Exam exam = new Exam();

        Student student = new Student();
        TypedQuery<Student> query =  Panache.getEntityManager().createQuery(
                "select s from Student s where s.firstname = :fn and s.lastname = :ln",
                Student.class
                ).setParameter("fn", examDTO.getFirstname())
                .setParameter("ln", examDTO.getLastname());

        if(query.getResultList().size() != 0){
            student = query.getResultList().get(0);
        }


        Subject subject = new Subject();
        TypedQuery<Subject> querySubject =  Panache.getEntityManager().createQuery(
                        "select s from Subject s where s.description = :des",
                        Subject.class
                ).setParameter("des", examDTO.getSubjectDescription());

        if(querySubject.getResultList().size() != 0){
            subject = querySubject.getResultList().get(0);
        }

        exam.setStudent(student);
        exam.setSubject(subject);
        exam.setDate(examDTO.getDate());
        exam.setNote(examDTO.getNote());

        Panache.getEntityManager().persist(exam);
    }

    //TODO: Zeugnisübersicht (Schüler: Vorname, Nachname) -> Gegenstände mit gemittelten Noten (im SQL)
    public static List<SchoolReport> getOverview(String firstname, String lastname) {
        System.out.println(firstname + " " + lastname);
        List<SchoolReport> schoolReports = new LinkedList<SchoolReport>();

        TypedQuery<SchoolReport> query = Panache.getEntityManager().createQuery(
                "select new at.htl.dto.SchoolReport(s.abbreviation, e.note) from Subject s " +
                        "join Exam e on s.abbreviation = e.subject.abbreviation " +
                        "where e.student.firstname = :fn and e.student.lastname = :ln ",
                        //"group by s.abbreviation",
                SchoolReport.class
        ).setParameter("fn", firstname)
                .setParameter("ln", lastname);

        try{
            schoolReports = query.getResultList();
        }catch (Exception ex){
            //Theoretisch für Fehlermeldung statt Liste
        }

        System.out.println(query.getResultList());
        return schoolReports;
    }

}
