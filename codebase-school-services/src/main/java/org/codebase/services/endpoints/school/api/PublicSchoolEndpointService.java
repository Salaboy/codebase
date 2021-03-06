/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.codebase.services.endpoints.school.api;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codebase.model.school.Course;
import org.codebase.model.school.School;
import org.codebase.model.school.SchoolClass;
import org.codebase.model.school.Year;
import org.codebase.model.school.users.Student;
import org.codebase.model.school.users.Teacher;
import org.codebase.shared.exceptions.ServiceException;

/**
 *
 * @author salaboy
 */

@Path("/schools")
public interface PublicSchoolEndpointService extends Serializable {

    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    List<School> getAllSchools() throws ServiceException;
    
    @POST
    @Path("/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newSchool(@NotNull School school) throws ServiceException;
    
    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void updateSchool(@NotNull School school) throws ServiceException;
    
    @PUT
    @Path("courses/{id}/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void updateCourse(@PathParam("id") Long courseId, @NotNull Course course) throws ServiceException;
    
    @PUT
    @Path("students/{id}/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void updateStudent(@PathParam("id") Long studentId, @NotNull Student student) throws ServiceException;
    
    @DELETE
    @Path("/courses/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void deleteCourse(@PathParam("id") Long courseId) throws ServiceException;
    
    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void deleteSchool(@PathParam("id") Long schoolId) throws ServiceException;
    
    @DELETE
    @Path("/students/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void deleteStudent(@PathParam("id") Long studentId) throws ServiceException;


    @POST
    @Path("/courses/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newCourse(@NotNull Course course) throws ServiceException;

    @POST
    @Path("years/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newYear(@NotNull Year year) throws ServiceException;

    @POST
    @Path("classes/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newSchoolClass(@NotNull SchoolClass schoolClass) throws ServiceException;

    @POST
    @Path("students/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newStudent(@NotNull Student student) throws ServiceException;
    
    @PUT
    @Path("classes/{id}/enroll")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void enrollStudentToSchoolClass(@PathParam("id") Long schoolClassId, Student student) throws ServiceException;

    @GET
    @Path("{id}/students")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<Student> getStudentsBySchoolClassCode(@PathParam("id") Long newSchoolId, String code) throws ServiceException;

    @GET
    @Path("{id}/students")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<SchoolClass> getSchoolClassByYear(@PathParam("id") Long newSchoolId, String string) throws ServiceException;
    
    @GET
    @Path("{id}/years")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<Year> getYearsBySchool(@PathParam("id") Long newSchoolId) throws ServiceException;

    @GET
    @Path("{id}/courses")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<Course> getCoursesBySchool(@PathParam("id") Long newSchoolId) throws ServiceException;
    
    @GET
    @Path("/students")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<Student> getAllStudents() throws ServiceException;
  
    @GET
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    School getSchool(@PathParam("id") Long schoolId) throws ServiceException;
    
    @GET
    @Path("/courses/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Course getCourse(@PathParam("id") Long courseId) throws ServiceException;
    
    
    @GET
    @Path("/students/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Student getStudent(@PathParam("id") Long studentId) throws ServiceException;

    
    @GET
    @Path("/teachers/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Teacher getTeacher(@PathParam("id") Long teacherId) throws ServiceException;
    
    @GET
    @Path("/teachers")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    List<Teacher> getAllTeachers() throws ServiceException;
    
    @POST
    @Path("teachers/new")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    Long newTeacher(@NotNull Teacher teacher) throws ServiceException;
    
    @DELETE
    @Path("/teachers/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void deleteTeacher(@PathParam("id") Long teacherId) throws ServiceException;
    
    @PUT
    @Path("teachers/{id}/update")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    void updateTeacher(@PathParam("id") Long teacherId, @NotNull Teacher teacher) throws ServiceException;
    
}
