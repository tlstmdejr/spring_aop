package kr.co.sist.day0129;

import java.sql.SQLException;
import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	public void insert() throws SQLException {
		System.out.println("DBMS insert했어요");
	}

	public String select() throws SQLException {
		System.out.println("dbms에서 select");
		return "오늘은 목요일입니다";
	}

	public TestDomain selectTest() throws SQLException {
		TestDomain td = new TestDomain("민병조", 25);
		return td;
	}

	public TestDomain selectTest2() throws SQLException {
		TestDomain td = new TestDomain("민병조", 25);
		
		try {
			Thread.sleep(new Random().nextInt(30));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return td;
	}

	public TestDomain selectTest3() throws SQLException {
		TestDomain td = new TestDomain("민병조", 25);
		if (new Random().nextBoolean()) {
			throw new SQLException("sql 예외가 발생했습니다");
		}
		return td;
	}
	public void insert(String name,int age) throws SQLException {
		System.out.println("DBMS insert했어요"+name+"/"+age);
	}
	public void insert(TestDTO tDTO) throws SQLException {
		System.out.println("DBMS dto를 사용한insert했어요"+tDTO.getName()+"/"+tDTO.getAge());
	}
}
//class
