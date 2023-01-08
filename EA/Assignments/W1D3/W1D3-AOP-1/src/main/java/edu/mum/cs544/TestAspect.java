package edu.mum.cs544;

import java.util.Calendar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TestAspect {
    //Exercise 1-a), b), c)
    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(String, String))")
    public void createLog(JoinPoint jp){
        Object[] args=jp.getArgs();
        EmailSender sender = (EmailSender) jp.getTarget();
        System.out.println(Calendar.getInstance().getTime() + " method= " + jp.getSignature().getName()
        + " address= "+  args[0] + " message= " + args[1] 
        + " outgoing mail server = " + sender.getOutgoingMailServer());
    }

     //Exercise 1-d)
    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save = " + totaltime + "ms");
        return retVal;
    }

}
