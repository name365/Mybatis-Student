import com.github.subei.dao.BlogMapper;
import com.github.subei.pojo.Blog;
import com.github.subei.utils.IDutils;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class MyTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("功夫河粉");
        blog.setCreate_time(new Date());
        blog.setViews(998);

        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("Java如此困难");
        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("Spring如此困难");
        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("微服务如此困难");
        mapper.addBlog(blog);

        session.close();
    }
}
