package nl.workingspirit.ws_bootcampappbackend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPostService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentRequestService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentUpdateService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
*/
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentEndpointMockMvcTest {


    @InjectMocks
    private AssignmentEndpoint assignmentEndpoint;

    @Mock
    AssignmentPostService assignmentPostService;
    @Mock
    AssignmentUpdateService assignmentUpdateService;
    @Mock
    AssignmentRequestService assignmentRequestService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.assignmentEndpoint).build();
    }

    @Test
    public void testAddAssignment() throws Exception {

        //Given
        Assignment assignment = new Assignment();
        assignment.setDay("Monday");
        assignment.setTitle("Java Switch case assignment");
        assignment.setLevel("5");


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(assignment);

        Mockito.when(this.assignmentPostService.postAssignment(any(Assignment.class))).thenReturn(assignment);

        //when
        this.mockMvc.perform(post("/AddAssignment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
// then
                .andExpect(jsonPath("$.day", is(assignment.getDay())))
                .andExpect(jsonPath("$.title", is(assignment.getTitle())))
                .andExpect(jsonPath("$.level", is(assignment.getLevel())))
                .andExpect(status().isOk()
                );
    }

    @Test
    public void testGetAllAssignments() throws Exception {
        //Given
        Assignment assignment = new Assignment();
        assignment.setDay("Monday");
        assignment.setTitle("Java Switch case assignment");
        assignment.setLevel("5");

        Mockito.when(this.assignmentRequestService.requestAllAssignments()).thenReturn(Arrays.asList(assignment));

        //when
        this.mockMvc.perform(get("/GetAllAssignments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("")).andDo(print())
// then
                .andExpect(jsonPath("$[0].day", is(assignment.getDay())))
                .andExpect(jsonPath("$[0].title", is(assignment.getTitle())))
                .andExpect(jsonPath("$[0].level", is(assignment.getLevel())))
                .andExpect(status().isOk()
                );
    }
}
