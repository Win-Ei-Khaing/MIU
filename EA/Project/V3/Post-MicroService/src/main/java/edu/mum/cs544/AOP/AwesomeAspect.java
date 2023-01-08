package edu.mum.cs544.AOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AwesomeAspect {
    @Value("Test")
    private String text;

    public AwesomeAspect(){
        System.out.println("awesome aspect constru " + text);
    }

    @Before("execution(* edu.mum.cs544..*.*(..))")
    public void beforeTrace(JoinPoint jp){
        System.out.println(jp.getSignature().getName());
    }
}
