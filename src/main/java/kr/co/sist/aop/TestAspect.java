package kr.co.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {


	
	@After("execution(public String kr.co.sist.day0128.HelloService.*())")
	public void before() {
		
		
		System.out.println("지적질시작!!");
	}
}
//class
