package com.acrule.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author xuningkai
 * @Description: TODO(描述)
 * @date 2017年9月22日 上午9:53:53
 *
 */
public class MybatisUtils {
	public static SqlSessionFactory getFactory(){
        String resource="com/acrule/utils/conf.xml";
        
        //加载mybatis 的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
        
        //构建sqlSession 的工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        return factory;
    }
}

