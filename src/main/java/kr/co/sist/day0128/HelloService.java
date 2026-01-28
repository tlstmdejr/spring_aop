package kr.co.sist.day0128;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String helloMsg() {
		String msg="오늘은 수요일 입니다.";

		System.out.println("Target1 ");

		return msg;
	}
	public String helloMsg2() {
		String msg2="오늘은 수요일 입니다.";
		
		System.out.println("Target2 ");
		
		return msg2;
	}
}
//class
