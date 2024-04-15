package a0323i1_cinema_professtional_be.aop;

import a0323i1_cinema_professtional_be.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy

public class LoggerEmployee {
    static int count =0;
    @Before("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.findAll(..))")
    public void countRequest(){
        count++;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Number of visitors: " + count);
        System.out.println("------------------------------------------------------------------");
    }
    @AfterReturning("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.deleteById(..))")
    public void loggingException(JoinPoint joinPoint) {
        System.out.println("------------------------------------------------------------------");
        Object[] args = joinPoint.getArgs();
        int id  = (Integer) args[0];
        System.out.println("Delete employee with id : " + id);
        System.out.println("----------------------------------------------------------");
    }
    @Around("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.deleteById(..))")
        public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            System.out.println("------------------------------------------------------------------");
            System.out.println("-----------start");
            Object object= proceedingJoinPoint.proceed();
            System.out.println("-----------end");
            System.out.println("------------------------------------------------------------------");
            return object;
        }


}
