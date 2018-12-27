package com.java1234.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest3 {

	private static Logger logger=Logger.getLogger(StudentTest3.class);
	private SqlSession sqlSession=null;
	private StudentMapper studentMapper=null;
	
	/**
	 * ���Է���ǰ����
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	/**
	 * ���Է��������
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	
	@Test
	public void testFindStudent(){
		logger.info("��ѯѧ��");
		int offset=0,limit=3;
		//�ǽ����еļ�¼��ѯ���ڴ���ȥ��Ȼ���ڷ�ҳ��Ч�ʵ�
		RowBounds rowBounds=new RowBounds(offset,limit); 
		List<Student> studentList=studentMapper.findStudents(rowBounds);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudent2(){
		logger.info("��ѯѧ��");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", 3);
		map.put("size", 3);
		List<Student> studentList=studentMapper.findStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	
}
