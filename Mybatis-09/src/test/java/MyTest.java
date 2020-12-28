import com.github.subei.dao.UserMapper;
import com.github.subei.pojo.User;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void USTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("--------");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession.close();
    }

    @Test
    public void UpTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

      //  mapper.updateUser(new User(2,"kkkkk","ppppp"));

        sqlSession.clearCache(); //手动清理缓存

        System.out.println("--------");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession.close();
    }

}
