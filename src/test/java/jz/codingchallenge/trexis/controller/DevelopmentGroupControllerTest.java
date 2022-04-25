package jz.codingchallenge.trexis.controller;

import org.hamcrest.Matchers;
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
public class DevelopmentGroupControllerTest {

    private static final String MANAGER_A_DEV_GROUP_URL = "/departments/1/employees/1/devGroups";
    private static final String MANAGER_B_DEV_GROUP_URL = "/departments/1/employees/2/devGroups";
    private static final String MANAGER_C_DEV_GROUP_URL = "/departments/1/employees/3/devGroups";
    private static final String MANAGER_D_DEV_GROUP_URL = "/departments/1/employees/4/devGroups";
    private static final String MANAGER_E_DEV_GROUP_URL = "/departments/1/employees/3/devGroups";
    private static final String MANAGER_F_DEV_GROUP_URL = "/departments/1/employees/6/devGroups";


    @Autowired
    MockMvc mockMvc;

    @Test
    public void managerA_should_have_understaffed_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_A_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("Understaffed"));
    }

    @Test
    public void managerB_should_have_understaffed_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_B_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("Understaffed"));
    }

    @Test
    public void managerF_should_have_understaffed_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_F_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("Understaffed"));
    }

    @Test
    public void managerD_should_have_properly_staffed_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_D_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].status").value("Properly staffed"));
    }

    @Test
    public void managerC_should_not_have_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_C_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.empty()));
    }

    @Test
    public void managerE_should_not_have_dev_group() throws Exception {
        mockMvc.perform(get(MANAGER_E_DEV_GROUP_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.empty()));
    }

}
