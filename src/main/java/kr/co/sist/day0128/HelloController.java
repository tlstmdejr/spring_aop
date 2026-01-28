package kr.co.sist.day0128;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@Autowired
	private HelloService hs;
	@GetMapping("/")
	public String hello(Model model	) {
		String msg=hs.helloMsg();
		String msg2=hs.helloMsg2();
		model.addAttribute("msg",msg);
		model.addAttribute("msg",msg2);
		return"day0128/hello";
	}

}
//class
