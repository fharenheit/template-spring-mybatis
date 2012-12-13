package kr.co.cloudine.template.standalone;

import kr.co.cloudine.template.standalone.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello MyBatis Application.
 */
public class MyBatisApp {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        User selectUser = sqlSession.selectOne("select", "admin");
        System.out.println(selectUser);

        sqlSession.close();
    }

}
