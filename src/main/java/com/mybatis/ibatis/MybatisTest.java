package com.mybatis.ibatis;

import com.mybatis.ibatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {

    public static void main (String[] args) throws IOException {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
        // 第二个参数：指定传入sql的参数：这里是用户id
        User user = sqlSession.selectOne("MyMapper.selectUser", 1);
        System.out.println(user);



//
//        //1 4 2 1 3 2 1 4
//        //11122344
//
//        List<Integer> list = new ArrayList<Integer>();
//         int count =0;
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        list.add(1);
//          list.add(4);
//          list.add(2);
//          list.add(1);
//          list.add(3);
//          list.add(2);
//          list.add(1);
//          list.add(4);
//        Collections.sort(list);
//        for(int i=0;i<list.size();i++){
//            for(int j =i+1;j<list.size();j++){
//                if(list.get(i)!=list.get(j)){
//                       count = j -i;
//                       hashMap.put(list.get(i),count);
//                       count=0;
//                       i=j;
//                       break;
//                }
//            }
//
//        }
//
//        System.out.println(hashMap.size());


    }

}
