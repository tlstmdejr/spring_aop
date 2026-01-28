package kr.co.sist.day0128;

import org.springframework.stereotype.Service;

@Service
public class TestPointcutService1 {

	public String test() {

		return "매개변수없는 method";
	}
	public String test(String msg) {
		
		return "매개변수있는 method";
	}
	public String searchMember(String msg) {
		
		return "searchMember method";
	}
}
//class
