package kr.co.sist.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestPointcutAspect {
	
	@Before("execution(public String kr.co.sist.day0128.TestPointcutService.test())")
	public void before() {
		System.out.println("String이 반환형이면서 매개변수가 없는 test method");
	}
	@Before("execution(public String kr.co.sist.day0128.TestPointcutService.test(String))")
	public void before2() {
		System.out.println("String이 반환형이면서 매개변수가 test method");
	}
	@Before("execution(public String kr.co.sist.day0128.*.test(String))")
	public void before3(JoinPoint jp) {
		System.out.println(jp.getSignature()+"day0128패키지의 모든클래스중 String이 반환형이면서 매개변수가 String test method");
	}
	@Before("execution(public String kr.co.sist.day0128.*.sear*(String))")
	public void before4(JoinPoint jp) {
		System.out.println(jp.getSignature()+"day0128패키지의 모든클래스중 String이 반환형이면서 매개변수가 String search로 시작되는 모든 method");
	}
	@Before("execution(* kr.co.sist.day0128.*.*(..))")
	public void before5(JoinPoint jp) {
		System.out.println(jp.getSignature()+" day0128패키지의 모든 method");
	}
}
//class
