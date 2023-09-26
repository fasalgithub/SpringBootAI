package com.junittest.springboot.studentservices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junittest.springboot.studentservices.model.Course;
import com.junittest.springboot.studentservices.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentController#registerStudentForCourse(String, Course)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterStudentForCourse() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.junittest.springboot.studentservices.service.StudentService.addCourse(String, com.junittest.springboot.studentservices.model.Course)" because "this.studentService" is null
        //       at com.junittest.springboot.studentservices.controller.StudentController.registerStudentForCourse(StudentController.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42"};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/students/{studentId}/courses", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        Course course = new Course();
        course.setId("42");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(course));
        Object[] controllers = new Object[]{studentController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link StudentController#retrieveCoursesForStudent(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRetrieveCoursesForStudent() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.junittest.springboot.studentservices.service.StudentService.retrieveCourses(String)" because "this.studentService" is null
        //       at com.junittest.springboot.studentservices.controller.StudentController.retrieveCoursesForStudent(StudentController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42"};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/{studentId}/courses",
                uriVariables);
        Object[] controllers = new Object[]{studentController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link StudentController#retrieveDetailsForCourse(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRetrieveDetailsForCourse() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.junittest.springboot.studentservices.service.StudentService.retrieveCourse(String, String)" because "this.studentService" is null
        //       at com.junittest.springboot.studentservices.controller.StudentController.retrieveDetailsForCourse(StudentController.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{"42", "42"};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/students/{studentId}/courses/{courseId}", uriVariables);
        Object[] controllers = new Object[]{studentController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        //assertions
        Assertions.assertEquals(HttpStatus.OK.value(), actualPerformResult.andReturn().getResponse().getStatus());

        // Assert
        // TODO: Add assertions on result
    }
}

