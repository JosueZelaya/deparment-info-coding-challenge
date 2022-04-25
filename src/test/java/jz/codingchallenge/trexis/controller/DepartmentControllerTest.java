package jz.codingchallenge.trexis.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {

    private static final String DEPARTMENT_COST_PATH = "/departments/1/employees/cost";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void department_should_cost_222() throws Exception {
        mockMvc.perform(get(DEPARTMENT_COST_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(222));
    }

}
