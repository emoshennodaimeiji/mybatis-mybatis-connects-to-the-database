package edu.zut.cn;

import edu.zut.cn.mapper.PoetryMapper;
import edu.zut.cn.pojo.Poetry;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MyTest {
    SqlSession sqlSession;
    PoetryMapper poetryMapper;
    //日期格式刷，可把字符串刷成日期
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    @Before //所有test方法执行前都会执行的方法
    public void openSqlSession() throws IOException, ParseException {
        //用输入流读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(in);
        //取出sqlSession对象
        sqlSession = sql.openSession();
        //取出动态代理对象
        poetryMapper = sqlSession.getMapper(PoetryMapper.class);

        Date date = sf.parse("1967-11-13");//字符串转日期
    }
    @After
    public void closeSqlSession(){
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void select(){
        String[] names = {"三五七言","元日","锦瑟"};
        List<Poetry> all = poetryMapper.getAll(names);
        List<Poetry> pbd = poetryMapper.getByAuthorOrDynasty("dynasty", "唐");
        List<Poetry> pba = poetryMapper.getByAuthorOrDynasty("author", "李白");
        List<Poetry> list = poetryMapper.selectByAll(new Poetry("", "", "", ""));
        all.forEach(poetry -> System.out.println(poetry));
    }
    @Test
    public void insert(){
        Poetry jdk = new Poetry("jdk","maven","mybatis","springboot");
        Poetry jdk2 = new Poetry("jdk2","maven2","mybatis2","springboot2");
        List<Poetry> list = new ArrayList<>();
        list.add(jdk);
        list.add(jdk2);
        int i = poetryMapper.addAll(list);
        System.out.println(i);
        sqlSession.commit();
    }
    @Test
    public void delete(){
        String[] names = {"45","554","555","990","991","996","jdk"};
        int i = poetryMapper.removeAll(names);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void update(){
        int num = poetryMapper.updateBySet(new Poetry("67","de","",""));
        System.out.println(num);
        sqlSession.commit();
    }

    @Test
    public void testUuid(){
        UUID uuid =UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }



    /*@Test
    public void testSelect(){
        *//*List<Poetry> list = session.selectList("zzh.getAll");
        list.forEach(poetry -> System.out.println(poetry));*//*
        Poetry poetry = session.selectOne("zzh.getByName","三五七");
        System.out.println(poetry);
        *//*List<Poetry> list = session.selectList("zzh.getByAuthor","李白");
        list.forEach(poetry -> System.out.println(poetry));*//*
    }
    @Test
    public void testInsert(){
        int sum = session.insert("zzh.add",new Poetry("9945","2","33","4"));
        session.commit();//增删改之后必须手动提交事务
        System.out.println(sum);
    }
    @Test
    public void testDelete(){
        int sum = session.delete("zzh.removeByName","9945");
        System.out.println(sum);
        session.commit();
    }
    @Test
    public void testUpdate(){
        int sum = session.update("zzh.updateByName",new Poetry("9945","车速","778","676"));
        System.out.println(sum);
        session.commit();
    }*/

}
