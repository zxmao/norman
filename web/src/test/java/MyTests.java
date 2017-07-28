import com.junxiong.norman.entity.User;
import com.junxiong.norman.dto.UserDTO;
import com.junxiong.norman.service.UserService;
import com.junxiong.norman.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjunxiong
 * @since 2017/7/27
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@SpringBootTest
public class MyTests {
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mvc;
    @Test
    public void addUser() {
        List<User> users = userService.saveUser(new UserDTO.AddUser()
                .setName("添加用户")
                .setUserEmail("junxiongz@163.com")
                .setMobile("15601942893")
                .setNickName("Christoper")
                .setOpId("opid001423141312")
                .setUnId("unid931246183"));
        System.out.println(users);
    }

    @Test
    public void addUserMock() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name","添加用户1");
        param.put("userEmail","junxiongzhang@gmail.com");
        param.put("mobile","15601942893");
        param.put("nickName","Christoper1");
        param.put("opId","opId17668835713123868");
        param.put("unId","unId42412412414141313");
        String mock = MockUtil.mock(mvc, "/user/save", param);
        System.out.println(mock);
    }
}
