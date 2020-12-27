import com.github.subei.dao.BlogMapper;
import com.github.subei.pojo.Blog;
import com.github.subei.utils.IDutils;
import com.github.subei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Test
    public void IFTest(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","java如此困难");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for(Blog blog : blogs){
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void chooseTest(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // map.put("title","java如此困难");
        map.put("views",998);

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for(Blog blog : blogs){
            System.out.println(blog);
        }

        session.close();
    }

    @Test
    public void updateBlogTest(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","SpringMVC如此困难");
        map.put("id","9527");

        mapper.updateBlog(map);

        session.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);

        hashMap.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(hashMap);
        for (Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
