package ca.lambton.exam;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.context.annotation.Import;

@WebMvcTest(UserRestController.class)
@Import(UserCacheTestConfig.class)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserCache userCache;

    @Test
    public void testGetMostPaidOccupation() throws Exception {
        Occupation mockOccupation = new Occupation("Engineer", 120000);
        when(userCache.getOccupationWithLargestSalary()).thenReturn(mockOccupation);

        mockMvc.perform(get("/mostpaid"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"title\":\"Engineer\",\"salary\":120000}"));
    }

    @Test
    public void testGetMostPaidOccupation_NoOccupation() throws Exception {
        when(userCache.getOccupationWithLargestSalary()).thenReturn(null);

        mockMvc.perform(get("/mostpaid"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"title\":\"No Occupation\",\"salary\":0}"));
    }
}

@Configuration
class UserCacheTestConfig {
    @Bean
    public UserCache userCache() {
        return Mockito.mock(UserCache.class);
    }
}
