package a0323i1_cinema_professtional_be.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;
@Aspect
@Component
@EnableAspectJAutoProxy

public class LoggerEmployee {
    static int count = 0;
    Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.findAll(..))")
    public void countRequest() {
        count++;
        logger.info("------------------------------------------------------------------");
        logger.info("Number of visitors: " + count);
        logger.info("------------------------------------------------------------------");
    }

    @AfterReturning("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.deleteById(..))")
    public void loggingException(JoinPoint joinPoint) {
        logger.info("------------------------------------------------------------------");
        Object[] args = joinPoint.getArgs();
        String id = (String) args[0];
        logger.info("Delete employee with id : " + id);
        logger.info("----------------------------------------------------------");
    }

    @Around("execution(* a0323i1_cinema_professtional_be.controller.EmployeeController.deleteById(..))")
    public Object loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("------------------------------------------------------------------");
        logger.info("-----------start");
        Object object = proceedingJoinPoint.proceed();
        logger.info("-----------end");
        logger.info("------------------------------------------------------------------");
        return object;
    }


}
