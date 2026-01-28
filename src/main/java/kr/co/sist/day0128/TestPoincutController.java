package kr.co.sist.day0128;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//웹에요청을 받지만 응답을 모두 직접한는 컨트ㅗㄹㄹ
public class TestPoincutController {
	
	@Autowired
	private TestPointcutService1 tps;
	
	@Autowired
	private TestPointcutService2 tps2;
	
	@GetMapping("/pointcut")
	public String pointcut(){
		
		String msg=tps.test();
		return msg;
	}
	@GetMapping("/pointcut2")
	public String pointcut2(){
		
		String msg=tps.test("안영하세ㅛ>");
		return msg;
	}
	@GetMapping("/pointcut3")
	public String pointcut3(){
		
		String msg=tps.test("안영하세ㅛ>");
		String msg2=tps2.test("안영하세ㅛ>");
		return msg+"/"+msg2;
	}
	@GetMapping("/pointcut4")
	public String pointcut4(){
		
		String msg=tps.searchMember("kim");
		String msg2=tps2.searchAddr("kim");
		String msg3=tps2.searhAddr2("kim");
		return msg+"/"+msg2+"/"+msg3;
	}
	@GetMapping("/pointcut5")
	public String pointcut5(){
		
		String msg=tps.searchMember("kim");
		String msg2=tps2.searchAddr("kim");
		String msg3=tps2.searhAddr2("kim");
		String msg4=tps.test();
		String msg5=tps.test("안녕");
		return msg+"/"+msg2+"/"+msg3+"/"+msg4+"/"+msg5;
	}
	
}
//class
