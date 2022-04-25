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
public class EmployeeControllerTest {
    private static final String MANAGER_A_COST_URL = "/departments/1/employees/1/cost";
    private static final String MANAGER_B_COST_URL = "/departments/1/employees/2/cost";
    private static final String MANAGER_C_COST_URL = "/departments/1/employees/3/cost";
    private static final String MANAGER_D_COST_URL = "/departments/1/employees/4/cost";
    private static final String MANAGER_E_COST_URL = "/departments/1/employees/5/cost";
    private static final String MANAGER_F_COST_URL = "/departments/1/employees/6/cost";
    private static final String MANAGER_E_RESPONSIBILITY_URL = "/departments/1/employees/5/responsibilityStatus";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void managerA_should_cost_94() throws Exception {
        mockMvc.perform(get(MANAGER_A_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(94));
    }

    @Test
    public void managerB_should_cost_45() throws Exception {
        mockMvc.perform(get(MANAGER_B_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(45));
    }

    @Test
    public void managerC_should_cost_128() throws Exception {
        mockMvc.perform(get(MANAGER_C_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(128));
    }

    @Test
    public void managerD_should_cost_84() throws Exception {
        mockMvc.perform(get(MANAGER_D_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(84));
    }

    @Test
    public void managerE_should_cost_34() throws Exception {
        mockMvc.perform(get(MANAGER_E_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(34));
    }

    @Test
    public void managerF_should_cost_24() throws Exception {
        mockMvc.perform(get(MANAGER_F_COST_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(24));
    }

    @Test
    public void managerE_should_have_too_little_responsibility() throws Exception {
        mockMvc.perform(get(MANAGER_E_RESPONSIBILITY_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Too little responsibility"));
    }

}
