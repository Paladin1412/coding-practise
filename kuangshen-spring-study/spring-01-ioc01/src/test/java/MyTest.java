import com.wang.dao.UserDaoImpl;
import com.wang.dao.UserDaoMysqlImpl;
import com.wang.service.UserService;
import com.wang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-07 11:21
 **/
public class MyTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
//        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
