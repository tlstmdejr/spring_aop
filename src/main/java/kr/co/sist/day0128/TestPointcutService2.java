package kr.co.sist.day0128;

import org.springframework.stereotype.Service;

@Service
public class TestPointcutService2 {

	public String test() {

		return "Test2---매개변수없는 method";
	}
	public String test(String msg) {
		
		return "Test2----매개변수있는 method";
	}
	public String searchAddr(String msg) {
		
		return "searchAddr method";
	}
	public String searhAddr2(String msg) {
		
		return "searchAddr2 method";
	}
}
//class
