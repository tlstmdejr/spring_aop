package kr.co.sist.day0129;

import kr.co.sist.day0128.HelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/day0129")
@Controller
public class TestAdviceController {

    private final HelloController helloController;
	
	@Autowired
	private TestService ts;

    TestAdviceController(HelloController helloController) {
        this.helloController = helloController;
    }
	
	@GetMapping("/afterReturing")
	public String afterReturing() {
		
		boolean flag=ts.add();
		System.out.println("controller----------"+flag);
		
		return "/day0128/hello";
	}
	@GetMapping("/afterReturing2")
	public String afterReturing2() {
		
		String msg=ts.search();
		System.out.println("controller----------"+msg);
		
		return "/day0128/hello";
	}
	@GetMapping("/afterReturing3")
	public String afterReturing3() {
		
		TestDomain td=ts.searchDomain();
		System.out.println("controller----------"+td);
		
		return "/day0128/hello";
	}
	@GetMapping("/around")
	public String around() {
		
		TestDomain td=ts.searchDomain2();
		System.out.println("controller----------"+td);
		
		return "/day0128/hello";
	}
	@GetMapping("/AfterThrowing")
	public String AfterThrowing() {
		
		TestDomain td=ts.searchDomain3();
		System.out.println("controller----------"+td);
		
		return "/day0128/hello";
	}
	@GetMapping("/arguments")
	public String arguments() {
		
		boolean flag=ts.add("민병조",25);
		System.out.println("controller----------"+flag);
		
		return "/day0128/hello";
	}
	@GetMapping("/arguments2")
	public String arguments2(TestDTO testDTO) {
		
		boolean flag=ts.add(testDTO);
		System.out.println("controller----------"+flag);
		
		return "/day0128/hello";
	}
	
}
//class
