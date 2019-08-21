package yc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Slf4j
public class UserAopService {



   /* @Pointcut(POINT_CUT)
    public void printMethodTime(){

    }*/


    @Before("execution(* *(..))")
    public void before(){
        System.out.println("before");
    }

  /*  @Around("printMethodTime()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        joinPoint.proceed();
        System.out.println("yc around");
    }*/
}
