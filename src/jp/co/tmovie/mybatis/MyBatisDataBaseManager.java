package jp.co.tmovie.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis DB接続用クラス
 * @author y-furuyama
 */
public class MyBatisDataBaseManager {

	private static final String RESOURCE = "resources/mybatis/mybatis-config.xml";

	/**
	 * SqlSessionを生成する
	 * @return SqlSession
	 * @throws IOException
	 */
	public static SqlSession getSession() throws IOException {
		
		InputStream is = Resources.getResourceAsStream(RESOURCE);
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		return sf.openSession();
	}
}
