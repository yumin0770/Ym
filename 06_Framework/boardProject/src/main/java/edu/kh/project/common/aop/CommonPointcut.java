package edu.kh.project.common.aop;

import org.aspectj.lang.annotation.Pointcut;

//Pointcuts을 모아둘 서비스
public class CommonPointcut {

	@Pointcut("execution(* edu.kh.project..*Impl*.*(..))")
	public void serviceImplPointcut() {}
	
	
}
