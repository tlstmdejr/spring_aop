package kr.co.sist.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import kr.co.sist.day0129.TestDTO;
import kr.co.sist.day0129.TestDomain;

@Aspect
@Component
public class TestDay0129Aspect {

	@AfterReturning("execution(void kr.co.sist.day0129.TestDAO.insert())")//void->*로 대체가능
	public void afterVoid(JoinPoint jp) {
		System.out.println("반환형이 없는 method가 호출"+jp.getSignature());
		
	}
	@AfterReturning(pointcut="execution(String kr.co.sist.day0129.TestDAO.select())",
			returning ="msg" )//void->*로 대체가능
	public void afterReturning(JoinPoint jp,Object msg) {
		System.out.println("반환형이 있는 method가 호출"+jp.getSignature());
		System.out.println("반환형 값 "+msg);
		
	}
	@AfterReturning(pointcut="execution(kr.co.sist.day0129.TestDomain kr.co.sist.day0129.TestDAO.selectTest())",
			returning ="td" )//void->*로 대체가능
	public void afterReturning3(JoinPoint jp,TestDomain td) {
		System.out.println("반환형이 있는 method가 호출"+jp.getSignature());
		td.setName(td.getName()+"님");
		System.out.println("반환형 값 "+td);
		
	}
	@After("execution(String kr.co.sist.day0129.TestDAO.select())")
	public void after(JoinPoint jp) {
		System.out.println("after"+jp.getSignature());
		
	}
	@Around("execution( kr.co.sist.day0129.TestDomain kr.co.sist.day0129.TestDAO.selectTest2())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long st=System.currentTimeMillis();
		Object obj=pjp.proceed();//타겟메소드 호출
		long et=System.currentTimeMillis();
		System.out.println("around"+pjp.getSignature());
		System.out.println("수행시간"+(et-st)+"ms");
		
		return obj;
	}
	@AfterThrowing(pointcut="execution(kr.co.sist.day0129.TestDomain kr.co.sist.day0129.TestDAO.selectTest3())",
			throwing ="ex" )
	public void afterReturning3(JoinPoint jp,Throwable ex) {
		System.out.println("예외가있는 method가 호출"+jp.getSignature());
		
		System.out.println("발생된예외"+ex);
	}
	@Before("execution(void kr.co.sist.day0129.TestDAO.insert(String,int))")//String,int->..
	public void arguments(JoinPoint jp) {
		
		Object[]	obj=jp.getArgs();
		if(obj!=null) {
			System.out.println("입력값의 개수"+obj.length);
			for(Object val:obj) {
				System.out.println(val);
			}
			String name=(String)obj[0];
			int age=(int)obj[1];
			System.out.println("advice에서 이름:"+name+"/ 나이"+age);
		}
		System.out.println("입력 값 사용"+jp.getSignature().toShortString());
	}
	
	@Before("execution(void kr.co.sist.day0129.TestDAO.insert(kr.co.sist.day0129.TestDTO)) && args(dto)")
	public void arguments(JoinPoint jp,TestDTO dto) {
		if(dto!=null) {
		System.out.println("advice에서 dto값"+dto.getName()+"/"+dto.getAge());
		dto.setName("더워요 살려주세요");
		dto.setAge(21);
		}
		System.out.println("입력 값 사용"+jp.getSignature().toShortString());
	}
	
}
//class
