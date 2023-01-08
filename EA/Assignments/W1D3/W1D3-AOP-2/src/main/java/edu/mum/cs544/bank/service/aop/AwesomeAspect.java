package edu.mum.cs544.bank.service.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    // @PostConstruct
    // public void start(){
    //     System.out.println("awesome aspect start method "+ text);
    // }

    @Around("execution(* edu.mum.cs544.bank.*.get*(..))")
    public Object beforeTrace(ProceedingJoinPoint pjp) throws Throwable{
    String name = pjp.getTarget().getClass().getSimpleName();

    if(name.equals("BClass")){
        return "Something ";
    }
    return pjp.proceed();
    }
}
