package com.acrule;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.acrule.model.User;
import com.acrule.repository.UserMapper;
import com.acrule.utils.MybatisUtils;

/**
 * @author xuningkai
 * @Description: TODO(描述)
 * @date 2017年9月22日 上午10:03:53
 *
 */
public class UserMapperTest {
	
	//@Test
	public void testPath(){
		//下面是src根目录
		//Object object = UserMapperTest.class.getClassLoader().getResource("test.txt").getFile();
		Object object = UserMapperTest.class.getClassLoader().getResource("com/acrule/test.txt").getFile();
		//File file3 = new File(UserMapperTest.class.getClassLoader().getResource("test.txt").getFile()); 
		System.out.println(object);
	}
	
	@Test
    public void testInsert(){
        SqlSessionFactory factory=MybatisUtils.getFactory();
        SqlSession session=factory.openSession(true);
        //使用反射的方法
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        	mapper.insertT(new User(-1, "jack", 4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        session.close();
    }
    
    //@Test
    public void testDelete(){
        SqlSessionFactory factory=MybatisUtils.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.deleteById(1);
        session.close();
    }
    
    //@Test
    public void testUpdate(){
        SqlSessionFactory factory=MybatisUtils.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.updateT(new User(2, "jackfa", 232));
        session.close();
    }
    
    //@Test
    public void testGetUser(){
        SqlSessionFactory factory=MybatisUtils.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.getUser(2);
        session.close();
        System.out.println(user);
    }
    
    //@Test
    public void testGetAllUsers(){
        SqlSessionFactory factory=MybatisUtils.getFactory();
        SqlSession session=factory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<User> users=mapper.getAllUsers();
        
        session.close();
        System.out.println(users);
    }
}

