package kr.co.sist.day0129;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	//final을 사용하면 field 의존성 주입이 아니고 생성자 의존성 주입을 받아야한다
	private final TestDAO tDAO;

	public TestService(TestDAO tDAO) {
		this.tDAO = tDAO;
	}
	
	public boolean add() {
		boolean flag= false;
		
		try {
			tDAO.insert();
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	public String search() {
		String msg="";
		
		try {
			msg=tDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end try-catch
		
		
		return msg;
		
	}
	public TestDomain searchDomain() {
		TestDomain td=null;
		try {
			td=tDAO.selectTest();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end try-catch
		
		
		return td;
		
	}
	
	public TestDomain searchDomain2() {
		TestDomain td=null;
		try {
			td=tDAO.selectTest2();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end try-catch
		
		
		return td;
		
	}
	
	public TestDomain searchDomain3() {
		TestDomain td=null;
		try {
			td=tDAO.selectTest3();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end try-catch
		
		
		return td;
		
	}
	
	public boolean add(String name,int age) {
		boolean flag= false;
		
		try {
			tDAO.insert(name,age);
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public boolean add(TestDTO tDTO) {
		boolean flag= false;
		
		try {
			tDAO.insert(tDTO);
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
//class
