package at.htl.boundary;

import at.htl.dto.ExamDTO;
import at.htl.dto.SchoolReport;
import at.htl.model.Exam;
import at.htl.model.Student;
import at.htl.repository.ExamRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/exam")
@ApplicationScoped
public class ExamEndpoint {

    @Inject
    ExamRepository examRepository;

    @GET
    @Path("/examOverview/{firstname}/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<SchoolReport> getExamOverview(@PathParam("firstname")String firstname, @PathParam("lastname") String lastname) {
        return examRepository.getOverview(firstname, lastname);
    }

    @POST
    @Path("/createExam/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createExam(ExamDTO examDTO){
        examRepository.createExam(examDTO);
        return Response.created(URI.create("ok")).build();
    }
}
