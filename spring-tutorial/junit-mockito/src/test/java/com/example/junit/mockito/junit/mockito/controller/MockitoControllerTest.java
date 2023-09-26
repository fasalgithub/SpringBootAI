package com.example.junit.mockito.junit.mockito.controller;

import com.example.junit.mockito.junit.mockito.dao.MockitoJob;
import com.example.junit.mockito.junit.mockito.repository.MockitoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MockitoController.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest
class MockitoControllerTest {
    @Autowired
    private MockitoController mockitoController;

    @MockBean
    private MockitoRepository mockitoRepository;

    @Autowired
    private MockMvc mockMvc;

    Logger logger = LogManager.getLogger(MockitoControllerTest.class);

    @Test
    void testGetMyMockitoById() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        MockitoJob mockitoExpected = new MockitoJob(1, "test", "test");
        when(mockitoRepository.findById(1)).thenReturn(Optional.of(mockitoExpected));

        /*Object[] controllers = new Object[]{mockitoController};
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllers).build();*/

        MvcResult mvcResult = mockMvc.perform(

                MockMvcRequestBuilders
                        .get("/mockito/get-mock-id/{id}", 1).contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        MockitoJob mockitoJob = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), MockitoJob.class);
        logger.info("Status {}", mvcResult.getResponse().getStatus());
        Assertions.assertEquals(mockitoExpected.getMockitoName(), mockitoJob.getMockitoName());

    }

    /**
     * Method under test: {@link MockitoController#getMyMockitoById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMyAllMockitoById() throws Exception {
        List<MockitoJob> testMockitoJobs = Stream.of(new MockitoJob(1, "mockito-Junit", "Junit")
                , new MockitoJob(2, "mockito-selenium", "Selenium")
                , new MockitoJob(3, "mockito-unit", "Unit")).toList();

        when(mockitoRepository.findAll()).thenReturn(testMockitoJobs);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mockito/get-mocks")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andReturn();


        List<MockitoJob> mockitoJobList = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), List.class);

        Assertions.assertEquals(testMockitoJobs.size(), mockitoJobList.size());

    }

    /**
     * Method under test: {@link MockitoController#postMyMockito(MockitoJob)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPostMyMockito() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        MockitoJob mockitoJob = new MockitoJob(10, "save-test", "save-test");
        when(mockitoRepository.save(ArgumentMatchers.any())).thenReturn(mockitoJob);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/mockito/post-mock-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockitoJob))
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        MockitoJob postMockitoJob = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), MockitoJob.class);
        Assertions.assertEquals(mockitoJob.getMockitoName(), postMockitoJob.getMockitoName());
    }
}

