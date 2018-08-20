import biz.UserService;
import com.com.dao.SpittleRepository;
import com.spittr.Spittle;
import com.tradingplatform.controller.HelloController;
import dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @program: Tradingplatform
 * @description: test
 * @author: Robert_Wang
 * @create: 2018-08-17 17:19
 **/
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMain {

    @Autowired
    private UserService userService;


    @Test
    public void test() throws Exception {
//        HelloController controller = new HelloController();
//        MockMvc mockMvc = standaloneSetup(controller).build();
//        mockMvc.perform(get("/")).andExpect(view().name("home"));
        System.out.println("fsd");
    }

    @Test
    public void shouldShowRecentSpittles() {

    }

}
