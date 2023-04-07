package MyTest;

import com.beihua.mapper.UserMapper;
import com.beihua.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //启动容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})

public class Mytest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getRowCount(){
        System.out.println(userMapper.getRowCount("",""));
    }

    @Test
    public void selectUserPage(){
        System.out.println(userMapper.getRowCount("",""));
    }

    @Test
    public void deleteUserById(){
        System.out.println(userMapper.deleteUserById("15968162087363060"));
    }

    @Test
    public void addUserBy(){
        System.out.println(userMapper.createUser(new User("12334671","占山","sda","dsa","da","da","sda")));
    }


}
